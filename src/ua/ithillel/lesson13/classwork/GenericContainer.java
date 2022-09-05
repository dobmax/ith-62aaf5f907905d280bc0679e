package ua.ithillel.lesson13.classwork;

/**
 * T - type or data type
 * E - element
 * R - result
 * ID - identificator
 * K - key
 * V - value
 * RES - response
 * REQ - request
 * IN - input
 * OUT - output
 */
public class GenericContainer<T> {

    private final T val;

    public GenericContainer(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

}
