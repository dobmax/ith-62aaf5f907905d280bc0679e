package ua.ithillel.lesson26.classwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingClass {

    private static final Logger log = LogManager.getLogger(LoggingClass.class);

    public void testLogging() {
        log.info("Hello from {}", getClass());
        log.debug("Debug signal from {}", getClass());
    }
}
