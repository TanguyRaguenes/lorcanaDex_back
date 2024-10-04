// package fr.app.lorcanaDex.configuration;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;

// @Configuration
// public class WebConfig {

// @Bean
// public WebMvcConfigurer corsConfigurer() {
// return new WebMvcConfigurer() {
// @Override
// public void addCorsMappings(CorsRegistry registry) {

// System.out.println("Je suis bien appelé !!!!");
// registry.addMapping("/api/**")
// .allowedOrigins("http://localhost:4200")
// .allowedMethods("GET", "POST", "PUT", "DELETE")
// .allowedHeaders("Authorization", "Content-Type", "*")
// .allowCredentials(true);
// }
// };
// }

// }
