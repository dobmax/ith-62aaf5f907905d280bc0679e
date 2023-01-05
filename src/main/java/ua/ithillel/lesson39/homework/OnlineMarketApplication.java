package ua.ithillel.lesson39.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson39.classwork.data.access.CountryDaoService;
import ua.ithillel.lesson39.classwork.data.access.DataSourceConfiguration;

public class OnlineMarketApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
    }
}
