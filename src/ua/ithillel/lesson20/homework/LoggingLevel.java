package ua.ithillel.lesson20.homework;

public enum LoggingLevel {
    DEBUG(4),
    INFO(3),
    ERROR(2),
    WARNING(1),
    ;

    private final int order;

    LoggingLevel(int order) {
        this.order = order;
    }

    public int order() {
        return order;
    }
}
