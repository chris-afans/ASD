package edu.miu.cs.cs489.adsmgtcliapp.config;

import edu.miu.cs.cs489.adsmgtcliapp.filter.JWTAuthFilter;
import edu.miu.cs.cs489.adsmgtcliapp.service.implementation.AdsUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AdsWebAPISecurityConfig {

    private AdsUserDetailsService adsUserDetailsService;
    private JWTAuthFilter jwtAuthFilter;

    public AdsWebAPISecurityConfig(AdsUserDetailsService adsUserDetailsService, JWTAuthFilter jwtAuthFilter) {
        this.adsUserDetailsService = adsUserDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> {
                            auth
                                    .requestMatchers("/adsweb/api/v1/surgerylocations").permitAll()
                                    .requestMatchers("/adsweb/api/v1/patient/**").authenticated()
                                    .requestMatchers("/adsweb/api/v1/dentist/**").authenticated()
                                    .requestMatchers("/adsweb/api/v1/appointment/**").authenticated()
                                    .requestMatchers("/adsweb/api/v1/surgerylocation/**").authenticated()
                                    .requestMatchers("/adsweb/api/v1/address/**").authenticated();
//                                    .requestMatchers("/citylibrary/api/v1/publisher/get/**").authenticated();
                        }
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(adsUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
