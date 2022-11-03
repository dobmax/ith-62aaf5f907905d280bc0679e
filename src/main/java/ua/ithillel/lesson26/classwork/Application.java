package ua.ithillel.lesson26.classwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import ua.ithillel.lesson26.classwork.pkg.LoggedClassClone;

import java.util.UUID;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        ThreadContext.put("traceId", UUID.randomUUID().toString());
        startup();
        new LoggingClass().testLogging();
        new LoggedClassClone().testLogging();
        new LoggedClassClone().testLogging();
    }

    static void startup() {
        log.info("Application is starting ...");
        log.error("error signal ...");
        log.debug("debug signal ...");
    }
}
