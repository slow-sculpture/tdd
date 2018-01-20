package pl.sda.poznan.shop.repository;

import pl.sda.poznan.shop.exceptions.ProductNotFoundException;
import pl.sda.poznan.shop.model.Product;

import java.util.List;
import java.util.Optional;


public class ProductRepository {

    private static Long id = 1L;
    private List<Product> products;

    public Product add(Product product) {
        //nadac id dla produktu
        product.setId(id++);
        this.products.add(product);
        return product;
    }

    public Product getById(Long id) {
        Optional<Product> first = this.products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
        return first
                .orElseThrow(() ->
                                new
                                        ProductNotFoundException("Nie ma produktu o takim id")
                        //rozszerza RuntimeException ->wyjatek niekontrolowany nie trzeba go obslugiwac
                        //ani dodawac przy nazwie metody
                );
    }

    public Product getByName(String name) {
        Optional<Product> first = this.products.stream().filter(x -> x.getName().equals(name))
                .findFirst();
        return first
                .orElseThrow(() ->
                        new ProductNotFoundException
                                ("Nie mozna znalezc produktu o danej nazwie"));
    }

    public boolean remove(Long id) {
        return this.products.removeIf(p -> p.getId().equals(id));
    }

    public boolean remove(Product product) {
        return this.products.remove(product);
    }

    public int count() {
        return this.products.size();
    }
}
