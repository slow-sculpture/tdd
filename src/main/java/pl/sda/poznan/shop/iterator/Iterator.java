package pl.sda.poznan.shop.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    void reset();
}
