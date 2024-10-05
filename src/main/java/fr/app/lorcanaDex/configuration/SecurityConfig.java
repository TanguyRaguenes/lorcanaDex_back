package fr.app.lorcanaDex.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import javax.sql.DataSource;

import fr.app.lorcanaDex.dto.JwtRequestFilter;
import fr.app.lorcanaDex.dto.JwtUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // private final JwtUtil jwtUtil;
    // private final UserDetailsService userDetailsService;

    // public SecurityConfig(JwtUtil jwtUtil, UserDetailsService userDetailsService)
    // {
    // this.jwtUtil = jwtUtil;
    // this.userDetailsService = userDetailsService;
    // }

    // @Bean
    // public JwtRequestFilter jwtRequestFilter() {
    // return new JwtRequestFilter(jwtUtil, userDetailsService);
    // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtRequestFilter jwtRequestFilter)
            throws Exception {

        System.out.println("coucou");

        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests((authorize) -> authorize

                .requestMatchers("/").permitAll()
                .requestMatchers("/login").permitAll()
                .anyRequest().authenticated()
        // .anyRequest().permitAll()

        );

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");
        manager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
        return manager;
    }

    // @Bean
    // public AuthenticationManager
    // authenticationManager(AuthenticationConfiguration authConfig) throws
    // Exception {
    // return authConfig.getAuthenticationManager();
    // }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, DataSource dataSource) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.userDetailsService(userDetailsManager(dataSource)).passwordEncoder(passwordEncoder());
        return authBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utilisation de BCrypt pour le hachage des mots de passe
    }
}

// import javax.sql.DataSource;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public UserDetailsManager userDetailsManager(DataSource dataSource) {

// JdbcUserDetailsManager jdbcUserDetailsManager = new
// JdbcUserDetailsManager(dataSource);

// jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT pseudo, password,1
// FROM account WHERE pseudo=?");

// jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT pseudo, role
// FROM role WHERE pseudo=?");

// return jdbcUserDetailsManager;
// }

// @Bean
// public SecurityFilterChain web(HttpSecurity http) throws Exception {

// http.authorizeHttpRequests((authorize) -> authorize

// .requestMatchers("/").authenticated()
// .requestMatchers("/login").permitAll()
// .requestMatchers("/logout").authenticated()
// .requestMatchers("/get-cards").authenticated()
// .requestMatchers("/api/cards").authenticated()
// .requestMatchers("/api/cards/{pageNumber}").authenticated()
// .requestMatchers("/show-home").authenticated()
// .requestMatchers("/show-cards-list").permitAll()
// .requestMatchers("/bulk-data").hasAuthority("ROLE_ADMIN")
// .requestMatchers("/get-cards").authenticated()
// .requestMatchers("/get-cards/{filterKey}/{filterValue}").authenticated()
// .requestMatchers("/css/**").permitAll()
// .requestMatchers("/ts/**").permitAll()
// .anyRequest().authenticated()

// );

// http.formLogin(Customizer.withDefaults());

// return http.build();
// }

// };
