package com.intgracion_comunitaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Definir un Bean para PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración de seguridad HTTP
    @SuppressWarnings({ "deprecation", "removal", "removal" })
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/register", "/css/**", "/js/**", "/images/**").permitAll() // Permitir acceso sin
                                                                                             // autenticación
                .anyRequest().authenticated() // El resto de las rutas requieren autenticación
                .and()
                .formLogin()
                .loginPage("/login") // Página de login personalizada (si la tienes)
                .permitAll() // Permitir acceso a la página de login
                .and()
                .logout()
                .permitAll(); // Permitir logout

        return http.build(); // Construir la configuración de seguridad
    }
}
