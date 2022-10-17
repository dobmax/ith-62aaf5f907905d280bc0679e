package ua.ithillel.lesson20.homework;

/**
 * Таблица видимости:
 *
 * | LEVEL  | INFO  | DEBUG |
 *
 * | INFO   |   X   |       |
 *
 * | DEBUG  |   X   |   X   |
 */
public interface Logger {
    void info(String message);
    void debug(String message);
}
