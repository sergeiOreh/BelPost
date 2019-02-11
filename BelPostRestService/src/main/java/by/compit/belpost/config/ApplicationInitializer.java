package by.compit.belpost.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс ApplicationInitializer является классом-инициализатором,
 * который вызывает класс конфигурации при запуске приложения.
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Происходит вызыв классов конфигурации при запуске приложения.
     */
    @Override
    protected Class[] getRootConfigClasses() {
        return new Class[] { ApplicationConfiguration.class };
    }

    @Override
    protected Class[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}