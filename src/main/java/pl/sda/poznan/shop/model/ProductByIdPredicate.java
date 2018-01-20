package pl.sda.poznan.shop.model;

import java.util.function.Predicate;

public class ProductByIdPredicate implements Predicate<Product> {

  private Long id;

  public ProductByIdPredicate(Long id) {
    this.id = id;
  }

  @Override
  public boolean test(Product product) {
    return product.getId().equals(id);
  }
}
