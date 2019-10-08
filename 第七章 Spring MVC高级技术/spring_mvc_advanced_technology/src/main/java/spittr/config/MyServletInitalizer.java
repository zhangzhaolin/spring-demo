package spittr.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class MyServletInitalizer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addServlet("myServlet", MyServlet.class)
                .addMapping("/custom/**");
    }

    public static class MyServlet extends HttpServlet {

        @Override
        public void init(ServletConfig config) throws ServletException {
            System.out.println("MyServlet启动.......");
            super.init(config);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doGet(req, resp);
        }




    }
}
