package pl.sda.poznan.shop.iterator;

public interface IteratorMy<T> {
    boolean hasNext();
    T next();
    void reset();
}
