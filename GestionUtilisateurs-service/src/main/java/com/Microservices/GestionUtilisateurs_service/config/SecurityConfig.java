package com.Microservices.GestionUtilisateurs_service.config;

import com.Microservices.GestionUtilisateurs_service.Service.AuthService;
import com.Microservices.GestionUtilisateurs_service.Service.UserDetailsImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private final UserDetailsImp ServiceImp;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                //1 Désactive la protection CSRF
                .csrf(AbstractHttpConfigurer::disable)
                //2 Configure les règles d'autorisation des requêtes HTTP
                .authorizeHttpRequests(
                        req->req
                                .requestMatchers("/**").permitAll()
//                        .requestMatchers("/admin/**","/adminuser/**", "/admintech/**").hasAuthority("ADMIN")
//
//                        .requestMatchers("/technician/**", "/admintech/**").hasAuthority("TECH")
//
//                        .requestMatchers("/user/**","/adminuser/**").hasAuthority("USER")
                                // Exige une authentification pour toute autre requête non spécifiée
                                .anyRequest().authenticated()
                )
                //3
                .userDetailsService(ServiceImp)
                //4 Configure la gestion des sessions
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //5 Ajoute un filtre personnalisé JWT
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                //6  Gère les exceptions
                .exceptionHandling(
                        e->e.accessDeniedHandler(
                                        (request, response, accessDeniedException)->response.setStatus(403)
                                )
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .build();

    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}