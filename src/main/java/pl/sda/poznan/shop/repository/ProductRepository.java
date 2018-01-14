package pl.sda.poznan.shop.repository;

import pl.sda.poznan.shop.model.Product;

import java.util.List;

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
        throw new UnsupportedOperationException();
    }

    public Product getByName(String name){
        throw new UnsupportedOperationException();
    }

    public void remove(Long id) {
        throw new UnsupportedOperationException();
    }

    public void remove(Product product){
        throw new UnsupportedOperationException();
    }
    public int count(){
        throw new UnsupportedOperationException();
    }
}
