package by.compit.belpost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Класс ApplicationConfiguration является конфигурационным классом проекта.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "by.compit.belpost")
@PropertySource(value = {"classpath:application.properties"})
public class ApplicationConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
