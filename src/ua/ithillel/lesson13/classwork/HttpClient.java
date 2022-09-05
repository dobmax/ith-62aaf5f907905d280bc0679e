package ua.ithillel.lesson13.classwork;

public interface HttpClient {
    <T, CTX> T get(CTX request);
    <T> Iterable<T> getAll();
    <T> T post(T body);
    void delete(long id);
}
