package ua.ithillel.lesson39.classwork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson39.classwork.data.access.CountryDaoService;
import ua.ithillel.lesson39.classwork.data.access.DataSourceConfiguration;

public class DatabaseApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        System.out.println(context.getBean(CountryDaoService.class));
    }
}
