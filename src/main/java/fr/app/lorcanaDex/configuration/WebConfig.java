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

import java.util.Arrays;

@Configuration
// @EnableWebMvc
public class WebConfig {

        @Bean
        public FilterRegistrationBean<CorsFilter> corsFilter() {

                UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

                CorsConfiguration corsConfiguration = new CorsConfiguration();

                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.addAllowedOrigin("http://localhost:4200");
                corsConfiguration.setAllowedHeaders(Arrays.asList(

                                HttpHeaders.AUTHORIZATION,
                                HttpHeaders.CONTENT_TYPE,
                                HttpHeaders.ACCEPT,
                                HttpHeaders.ORIGIN,
                                "username"));

                corsConfiguration.setAllowedMethods(Arrays.asList(

                                HttpMethod.GET.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.PUT.name(),
                                HttpMethod.DELETE.name(),
                                HttpMethod.OPTIONS.name()));

                corsConfiguration.setMaxAge(3600L); // Cache la configuration pendant 3600 secondes (1 heure)

                urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

                FilterRegistrationBean<CorsFilter> filterRegistrationBean = new FilterRegistrationBean<>(
                                new CorsFilter(urlBasedCorsConfigurationSource));

                filterRegistrationBean.setOrder(-102);

                return filterRegistrationBean;
        }

}