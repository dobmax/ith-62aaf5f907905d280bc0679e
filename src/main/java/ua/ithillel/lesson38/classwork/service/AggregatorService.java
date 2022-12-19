package ua.ithillel.lesson38.classwork.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AggregatorService {
    private final OwnService ownServiceOne;
    private final OwnService ownServiceTwo;

    public AggregatorService(OwnService ownServiceOne, @Qualifier("customOwnServiceTwo") OwnService ownServiceTwo) {
        this.ownServiceOne = ownServiceOne;
        this.ownServiceTwo = ownServiceTwo;
    }
}
