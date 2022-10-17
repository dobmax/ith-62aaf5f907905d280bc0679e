package ua.ithillel.lesson20.homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements Logger {

    private final FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void info(String message) {
        if (configuration.getCurrentLevel().order() < LoggingLevel.INFO.order()) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configuration.getTarget(), true))) {
            writer.write(String.format(configuration.getTemplate(), new Date(), LoggingLevel.INFO, message));
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(String.format(
                    "Something went wrong during writing log of %s to %s",
                    LoggingLevel.INFO,
                    configuration.getTarget()
            ));
        }
    }

    @Override
    public void debug(String message) {
        if (configuration.getCurrentLevel().order() < LoggingLevel.DEBUG.order()) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configuration.getTarget(), true))) {
            writer.write(String.format(configuration.getTemplate(), new Date(), LoggingLevel.INFO, message));
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(String.format(
                    "Something went wrong during writing log of %s to %s",
                    LoggingLevel.INFO,
                    configuration.getTarget()
            ));
        }
    }
}
