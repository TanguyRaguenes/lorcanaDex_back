package fr.app.lorcanaDex.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays; // Utilisé pour convertir un tableau en liste avec la méthode asList()

@Configuration // Indique que cette classe contient des configurations pour Spring
@EnableWebMvc // Active le support MVC pour les applications web Spring
public class WebConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // Source pour configurer les règles CORS sur des URL spécifiques
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Crée une nouvelle configuration CORS
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Permet aux navigateurs d'inclure des informations d'authentification (cookies, authentification HTTP)

        // Ajoute un domaine autorisé à faire des requêtes CORS (ici, l'application front-end sur localhost:4200)
        config.addAllowedOrigin("http://localhost:4200");

        // Spécifie les en-têtes qui peuvent être utilisés dans les requêtes CORS
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,  // Autorise les en-têtes pour l'authentification
                HttpHeaders.CONTENT_TYPE,   // Autorise les en-têtes pour indiquer le type de contenu
                HttpHeaders.ACCEPT));       // Autorise les en-têtes pour indiquer les types de réponses acceptées

        // Spécifie les méthodes HTTP autorisées pour les requêtes CORS
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),      // Autorise les requêtes GET
                HttpMethod.POST.name(),     // Autorise les requêtes POST
                HttpMethod.PUT.name(),      // Autorise les requêtes PUT
                HttpMethod.DELETE.name()    // Autorise les requêtes DELETE
        ));

        // Définit la durée pendant laquelle la configuration CORS peut être mise en cache par le navigateur
        config.setMaxAge(3600L); // Cache la configuration pendant 3600 secondes (1 heure)

        // Enregistre la configuration CORS pour toutes les URL (/**)
        source.registerCorsConfiguration("/**", config);

        // Crée un bean FilterRegistrationBean avec le filtre CORS
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        // Définit l'ordre du filtre, utile lorsque plusieurs filtres sont utilisés (ici, priorité haute avec -102)
        bean.setOrder(-102);

        // Retourne le bean pour que Spring puisse l'utiliser
        return bean;
    }

}