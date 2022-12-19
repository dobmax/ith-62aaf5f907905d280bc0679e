package ua.ithillel.lesson38.classwork.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Component
 * @Service
 * @Repository
 * @Configuration
 * @Bean
 * @Controller
 * @RestController
 */
@Component
@Scope("prototype")
public class OwnServiceOne implements OwnService {

    @Override
    public String toString() {
        return "Own Service One bean: " + super.toString();
    }
}
