package config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;

public class MyServletInitializer implements WebApplicationInitializer{
    public void onStartup(ServletContext servletContext) throws ServletException {
        // !ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet",MyServlet.class);

        // !myServlet.setMultipartConfig(
        // !        new MultipartConfigElement("/tmp/spittr/uploads",
        // !                2*1024,4*1024,0));
        // !myServlet.addMapping("/custom/**");

        // !FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter",MyFilter.class);
        // !myFilter.addMappingForUrlPatterns(null,false,"/custom/**");



    }
}
