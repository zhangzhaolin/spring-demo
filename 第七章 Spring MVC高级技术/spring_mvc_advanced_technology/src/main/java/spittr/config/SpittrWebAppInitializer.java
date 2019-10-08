package spittr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * 配置DispatcherServlet
 *
 * @author shiwazi
 */
@Configuration
@PropertySource("classpath:application.properties")
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Value("${temp.spitter.upload.path}")
    private String locations;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement(locations, 2 * 1024 * 1024, 4 * 1024 * 1024, 0)
        );
    }


}
