package ua.ithillel.lesson38.classwork;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.lesson38.classwork.service.OwnService;
import ua.ithillel.lesson38.classwork.service.OwnServiceOne;
import ua.ithillel.lesson38.classwork.service.OwnServiceTwo;

public class SpringApplication {

    /**
     * 1. XML config
     * 2. Annotation config
     * 3. Java config
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ua.ithillel.lesson38.classwork.service");
        var ownService = ctx.getBean("ownServiceOne");
        var ownServiceCopy = ctx.getBean("ownServiceOne");
        System.out.println(ownService);
        System.out.println(ownServiceCopy);

        var ownService2 = ctx.getBean("customOwnServiceTwo");
        System.out.println(ownService2);

        var extService = ctx.getBean("externalServiceFirst");
        var extServiceCopy = ctx.getBean("externalServiceOne");
        System.out.println(extService);
        System.out.println(extServiceCopy);
    }
}
