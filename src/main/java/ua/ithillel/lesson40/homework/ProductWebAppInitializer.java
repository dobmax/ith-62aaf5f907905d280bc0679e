package ua.ithillel.lesson40.homework;

import jakarta.servlet.ServletContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ProductWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        // Create the 'root' Spring application context
        var rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebApplicationConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));


        // Register and map the dispatcher servlet
        var dispatcher = container.addServlet("ProductWebAppInitializer", new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
