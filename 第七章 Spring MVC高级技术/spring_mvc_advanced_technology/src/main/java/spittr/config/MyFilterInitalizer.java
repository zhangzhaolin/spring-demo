package spittr.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;

public class MyFilterInitalizer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext
                .addFilter("myFilter", MyFilter.class)
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    public static class MyFilter extends HttpFilter {
        @Override
        protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
            req.setCharacterEncoding("UTF-8");
            res.setCharacterEncoding("UTF-8");

            chain.doFilter(req, res);
        }
    }
}
