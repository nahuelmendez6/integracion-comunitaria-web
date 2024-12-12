package com.intgracion_comunitaria.controllers;

import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.model.UserProfile;
import com.intgracion_comunitaria.repositories.ProviderRepository;
import com.intgracion_comunitaria.repositories.UserProfileRepository;
import com.intgracion_comunitaria.repositories.UserRepository;
import com.intgracion_comunitaria.model.Availability;
import com.intgracion_comunitaria.model.Hour;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.services.AvailabilityService;
import com.intgracion_comunitaria.services.HourService;
import com.intgracion_comunitaria.services.ProviderService;
import com.intgracion_comunitaria.services.UserService;
import com.intgracion_comunitaria.services.WeekService;

import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import jakarta.persistence.criteria.Path;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
public class ProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private UserService userService;

    @Autowired
    private WeekService weekService;

    @Autowired
    private HourService hourService;

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/profile")
    public String viewProfile(Authentication authentication, Model model) {
        // Obtén el usuario autenticado
        String userEmail = authentication.getName(); // Correo del usuario autenticado
        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        if (userOptional.isEmpty()) {
            // Usuario no encontrado
            return "redirect:/error?message=Usuario no encontrado";
        }

        User user = userOptional.get();
        UserProfile userProfile = userProfileRepository.findByUserId(user.getId());

        // Verifica si un usuario es proveedor
        if (userProfile == null) {
            // Perfil del usuario no encontrado
            return "redirect:/error?message=Perfil no encontrado";
        }

        if (userProfile.getRoleType() == UserProfile.RoleType.proveedor) {
            Provider provider = providerRepository.findByUser(userProfile.getUser());

            if (provider == null) {
                // Proveedor no encontrado
                return "redirect:/error?message=Proveedor no encontrado";
            }

            model.addAttribute("provider", provider);
            return "prover_profile"; // Template del proveedor

        }

        // Si el usuario no es proveedor
        // Aca tiene que ir la logica para dar acceso a perfil de clientes
        return "redirect:/error?message=Acceso no permitido";

    }

    // Mostrar formulario de edicion
    @GetMapping("/edit_profile")
    public String showEditProfileForm(Authentication authentication, Model model) {
        // Obtén el usuario autenticado
        String userEmail = authentication.getName(); // Correo del usuario autenticado
        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        if (userOptional.isEmpty()) {
            // Usuario no encontrado
            return "redirect:/error?message=Usuario no encontrado";
        }

        User user = userOptional.get();
        UserProfile userProfile = userProfileRepository.findByUserId(user.getId());

        // Verifica si un usuario es proveedor
        if (userProfile == null) {
            // Perfil del usuario no encontrado
            return "redirect:/error?message=Perfil no encontrado";
        }

        if (userProfile.getRoleType() == UserProfile.RoleType.proveedor) {
            Provider provider = providerRepository.findByUser(userProfile.getUser());

            if (provider == null) {
                // Proveedor no encontrado
                return "redirect:/error?message=Proveedor no encontrado";
            }

            Long idProvider = provider.getIdProvider();

            Map<Integer, Availability> availability = availabilityService.getAvailabilityProvider(idProvider);

            model.addAttribute("provider", provider);
            model.addAttribute("categories", providerService.getAllCategories());
            model.addAttribute("professions", providerService.getAllProfessions());
            model.addAttribute("type_providers", providerService.getAllTypeProviders());
            model.addAttribute("type_jornals", providerService.getAllTypeJornals());
            model.addAttribute("weeks", weekService.getAllWeeks());
            model.addAttribute("hours", hourService.getAllHours());
            model.addAttribute("availability", availability);
            return "edit_provider_profile"; // Template del proveedor

        }

        // Si el usuario no es proveedor
        // Aca tiene que ir la logica para dar acceso a perfil de clientes
        return "redirect:/error?message=Acceso no permitido";

    }

    @PostMapping("/upload-photo")
    public String uploadProfilePicture(@RequestParam("profilePicture") MultipartFile file,
            @AuthenticationPrincipal UserDetails userDetails,
            RedirectAttributes redirectAttributes) {
        try {
            // Obtener usuario actual
            User user = userService.findByUsername(userDetails.getUsername());

            // Validar que el archivo no esté vacío
            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "El archivo está vacío.");
                return "redirect:/profile";
            }

            // Generar nombre único para el archivo
            String filename = user.getId() + "_" + file.getOriginalFilename();

            // Guardar archivo en una carpeta (por ejemplo, en /uploads)
            java.nio.file.Path path = Paths.get("uploads/" + filename);
            Files.createDirectories(path.getParent());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            // Guardar el nombre del archivo en la base de datos
            user.setProfilePicture(filename);
            userService.save(user);

            redirectAttributes.addFlashAttribute("success", "Foto de perfil actualizada con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ocurrió un error al subir la foto.");
        }
        return "redirect:/profile";
    }

    @PostMapping("/update")
    public String updateProfile(
            @ModelAttribute("provider") Provider provider,
            @RequestParam Map<String, String> availabilityData,
            RedirectAttributes redirectAttributes) {

        try {
            // Actualizar el proveedor
            providerService.updateProvider(provider);

            // Expresión regular para validar el formato de las claves
            // String availabilityPattern =
            // "availabilities\\[\\d+\\]\\.(fromHour|untilHour|week)\\.id";

            // Procesar las disponibilidades
            for (Map.Entry<String, String> entry : availabilityData.entrySet()) {
                if (entry.getKey().startsWith("availabilities")) {
                    // Extraer datos de disponibilidad del formulario
                    String[] keys = entry.getKey().split("\\.");
                    if (keys.length == 3 && keys[2].equals("week.id")) {
                        Integer weekId = Integer.valueOf(entry.getValue());

                        // Obtener desde y hasta hora
                        Long fromHourId = Long.valueOf(
                                availabilityData.getOrDefault("availabilities[" + weekId + "].fromHour.id", "0"));
                        Long untilHourId = Long.valueOf(
                                availabilityData.getOrDefault("availabilities[" + weekId + "].untilHour.id", "0"));

                        // Validar Week y Hour
                        Optional<Hour> fromHour = hourService.findById(fromHourId);
                        Optional<Hour> untilHour = hourService.findById(untilHourId);

                        if (fromHour.isPresent() && untilHour.isPresent()) {
                            Availability availability = new Availability();
                            availability.setProvider(provider);
                            availability.setWeek(weekService.findById(weekId)); // Asegúrate de que este método devuelva
                                                                                // un `Optional`

                            availability.setFromHour(fromHour.get());
                            availability.setUntilHour(untilHour.get());

                            // Guardar o actualizar disponibilidad
                            availabilityService.saveAvailability(availability);
                        }
                    }
                }
            }

            redirectAttributes.addFlashAttribute("successMessage", "Perfil actualizado correctamente");
            return "redirect:/profile";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "Error al actualizar el perfil: " + e.getMessage());
            return "redirect:/edit_profile";
        }
    }

}
