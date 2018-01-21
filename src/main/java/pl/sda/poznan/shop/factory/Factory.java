package pl.sda.poznan.shop.factory;

public interface Factory<K, V> {
    V create (K key);
}
