package spittr.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        FilterRegistration.Dynamic filterRegistration =  servletContext.addFilter("encodingFilter",new CharacterEncodingFilter("utf-8",true));
        filterRegistration.addMappingForUrlPatterns(null,false,"/*");
    }

}
