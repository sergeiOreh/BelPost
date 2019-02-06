package by.compit.belpost.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Класс ApplicationConfiguration является конфигурационным классом проекта.
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "by.compit.belpost")
@PropertySource("classpath:settings.properties")
public class ApplicationConfiguration {
}
