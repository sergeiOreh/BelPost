package by.compit.belpost.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс ApplicationConfiguration является конфигурационным классом проекта.
 */
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "by.compit.belpost.repository")
@ComponentScan(value = "by.compit.belpost")
@EntityScan(value = "by.compit.belpost.entity")
@PropertySource(value = {"classpath:settings.properties","classpath:application.properties"})
@SpringBootApplication
public class ApplicationConfiguration implements WebMvcConfigurer {

    /**
     * Запукает программу.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);

    }
}
