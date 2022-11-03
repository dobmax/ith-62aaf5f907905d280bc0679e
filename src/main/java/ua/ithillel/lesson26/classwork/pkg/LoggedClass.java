package ua.ithillel.lesson26.classwork.pkg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggedClass {

    private static final Logger log = LogManager.getLogger(LoggedClass.class);

    public void testLogging() {
        log.info("Hello from {}", getClass());
        log.debug("Debug signal from {}", getClass());
    }
}
