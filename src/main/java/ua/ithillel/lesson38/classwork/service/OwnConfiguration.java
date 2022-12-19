package ua.ithillel.lesson38.classwork.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ua.ithillel.lesson38.classwork.external.ExternalService;

@Configuration
public class OwnConfiguration {

    @Bean({"externalServiceOne", "externalServiceFirst"})
    public ExternalService externalService() {
        return new ExternalService();
    }

    @Bean
    @Scope("prototype")
    public ExternalService externalServiceTwo() {
        return new ExternalService();
    }

    @Bean
    public AggregatorService customAggregatorService(OwnService ownServiceOne,
                                                     @Qualifier("customOwnServiceTwo") OwnService ownServiceTwo) {
        return new AggregatorService(ownServiceOne, ownServiceTwo);
    }
}
