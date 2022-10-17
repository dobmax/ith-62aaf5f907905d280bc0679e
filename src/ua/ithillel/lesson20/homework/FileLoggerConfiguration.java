package ua.ithillel.lesson20.homework;

public class FileLoggerConfiguration {
    private String target;
    private LoggingLevel currentLevel;
    private int maxFileSize;
    private String template = "[%s][%s] Message: [%s]";

    public FileLoggerConfiguration(String target, LoggingLevel currentLevel, int maxFileSize) {
        this.target = target;
        this.currentLevel = currentLevel;
        this.maxFileSize = maxFileSize;
    }

    public String getTarget() {
        return target;
    }

    public LoggingLevel getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public String getTemplate() {
        return template;
    }
}
