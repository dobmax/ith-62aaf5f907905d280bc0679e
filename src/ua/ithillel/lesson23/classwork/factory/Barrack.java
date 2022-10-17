package ua.ithillel.lesson23.classwork.factory;

public interface Barrack {
    <T extends Unit> Unit invoke(Class<T> type);
}
