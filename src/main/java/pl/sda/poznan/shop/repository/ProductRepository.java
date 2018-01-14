package pl.sda.poznan.shop.repository;

import pl.sda.poznan.shop.model.Product;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        //starsze podejscie
        for (Product p : products) {
            if (p.equals(id)) {
                return p;
            }
        }
        products
                .stream()
                .filter(product -> product.getId().equals(id));
        //wyrazenie lambda
        //zapis funkcji anonimowej (bez nazwy)
        // lista_argumentow_funkcji ->
        //np.
        // public int sum(int a, int b){
        //  return a+b;
        //  }
        //    ==========
        //  (a, b)     -> a+b;

        //jezeli interfejs ma jedna metode to mozemy go zastapic wyrazeniem lambda

        throw new UnsupportedOperationException();
    }

    public Product getByName(String name) {
        //List<Product> collect = this.products
        // ==
        return this.products
                .stream()
                .filter(pr -> pr.getName().equals(name))
                .collect(Collectors.toList())
                .get(0);

    }

    public void remove(Long id) {
        throw new UnsupportedOperationException();
    }

    public void remove(Product product) {
        throw new UnsupportedOperationException();
    }

    public int count() {
        throw new UnsupportedOperationException();
    }
}
