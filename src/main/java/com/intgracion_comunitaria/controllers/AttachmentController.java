package com.intgracion_comunitaria.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.intgracion_comunitaria.model.Attachment;
import com.intgracion_comunitaria.model.Portfolio;
import com.intgracion_comunitaria.services.AttachmentService;
import com.intgracion_comunitaria.services.PortfolioService;

@Controller
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    PortfolioService portfolioService;

    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";

    // Obtener todos los adjuntos asociados a un portafolio
    @GetMapping("provider/portfolio/{portfolioId}")
    public List<Attachment> getAttachmentsByPortfolio(@PathVariable Long portfolioId) {
        return attachmentService.getAttachmentsByPortfolio(portfolioId);
    }

    // Agregar un adjunto (sin archivo)
    @PostMapping
    public Attachment addAttachment(@RequestBody Attachment attachment) {
        return attachmentService.addAttachment(attachment);
    }

    // Subir un archivo y asociarlo a un portafolio
    @PostMapping("provider/portfolio/upload")
    public Attachment uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("portfolioId") Long portfolioId,
            @RequestParam("userId") Integer userId) throws IOException {

        // Validar si el archivo no esta vacio
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede estar vacio");
        }

        // Definir la ruta para guardar el archivo
        // Generar nombre unico para cada imagen
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        String filePath = Paths.get(UPLOAD_DIR, fileName).toString();
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        // Recuperar el portfolio asociado
        Optional<Portfolio> portfolioOpt = portfolioService.getPortfolioById(portfolioId);
        Portfolio portfolio = portfolioOpt.get();

        // Crear y guardar la referencia del adjunto en la base de datos
        Attachment attachment = new Attachment();
        attachment.setName(fileName);
        attachment.setPath(filePath);
        attachment.setIdUserCreate(userId);
        attachment.setIdUserUpdate(userId);
        attachment.setPortfolio(portfolio);

        return attachmentService.addAttachment(attachment);

    }

}
