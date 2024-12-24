package com.intgracion_comunitaria.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

//import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.intgracion_comunitaria.model.Attachment;
import com.intgracion_comunitaria.model.Portfolio;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.model.UserProfile;
import com.intgracion_comunitaria.repositories.ProviderRepository;
import com.intgracion_comunitaria.repositories.UserRepository;
import com.intgracion_comunitaria.services.AttachmentService;
import com.intgracion_comunitaria.services.PortfolioService;
import com.intgracion_comunitaria.services.UserService;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private UserService userService;

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    @GetMapping("/add/portfolio")
    public String addPortolio(Model model) {
        model.addAttribute("portfolio", new Portfolio());
        return "new_portfolio";
    }

    @GetMapping("/view/portfolio/{id}")
    public String showPortfolio(@PathVariable("id") Long id, Model model) {
        // Obtener el portfolio y sus attachments
        Optional<Portfolio> portfolio = portfolioService.getPortfolioById(id);
        List<Attachment> attachments = attachmentService.getAttachmentsByPortfolio(id); // Asumiendo que la relación es
                                                                                        // una lista en el
        // modelo Portfolio

        // Agregar el portfolio y los attachments al modelo
        model.addAttribute("portfolio", portfolio.get());
        model.addAttribute("attachments", attachments);

        return "portfolioView"; // Nombre de la vista Thymeleaf
    }

    @PostMapping("/new/portfolio")
    public String newPortfolio(
            Authentication authentication,
            Model model,
            @ModelAttribute("portfolio") Portfolio portfolio,
            @RequestParam("images") MultipartFile[] images) {
        // Obtén el usuario autenticado
        String userEmail = authentication.getName(); // Correo del usuario autenticado
        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        if (userOptional.isEmpty()) {
            // Usuario no encontrado
            return "redirect:/error?message=Usuario no encontrado";
        }

        User user = userOptional.get();
        Provider provider = providerRepository.findByUserId(user.getId());

        if (provider == null) {
            // Si el proveedor no existe, redirigir a un error
            return "redirect:/error?message=Proveedor no encontrado";
        }

        User userProv = provider.getUser();

        // Asocia el proveedor al portfolio
        portfolio.setProvider(provider);
        portfolio.setIdUserCreate(userProv.getId());
        portfolio.setIdUserUpdate(userProv.getId());
        portfolio.setDateCreate(new Date());
        portfolio.setDateUpdate(new Date());

        // Usa el servicio para guardar el portfolio
        // portfolioService.createPortfolio(portfolio);

        Portfolio savedPortfolio = portfolioService.createPortfolio(portfolio);

        // Guardar imagenes
        for (MultipartFile file : images) {
            try {
                String fileName = file.getOriginalFilename();
                String fileType = getFileType(file);
                Path path = Paths.get(UPLOAD_DIR + File.separator + fileName);
                Files.write(path, file.getBytes());

                // Crear un attachment y asociarlo a un portfolio
                Attachment attachment = new Attachment();
                attachment.setName(fileName);
                attachment.setPath(path.toString());
                attachment.setFileType(fileType);
                attachment.setPortfolio(portfolio);
                attachment.setIdUserCreate(userProv.getId());
                attachment.setIdUserUpdate(userProv.getId());

                attachmentService.addAttachment(attachment);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Redirige a la vista de portfolios del proveedor
        return "redirect:/view/portfolio/" + savedPortfolio.getIdPortfolio();
    }

    // metodo para determnar el tipo de archivo
    private String getFileType(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

        switch (extension) {
            case "jpg":
            case "jpeg":
            case "png":
            case "gif":
                return "image";
            case "pdf":
                return "pdf";
            default:
                return "other";
        }
    }

}
