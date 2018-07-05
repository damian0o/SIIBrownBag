package pl.apso.optional.basic2;

import org.junit.Test;
import pl.apso.optional.modeling.Product;

import java.util.Optional;

public class Optional_4_check_filter_map_Test {


  @Test
  public void check_if_not_empty_filter_and_map() {
    Product product = new Product();

    String message = "Without tea in name :(";
    // case
    if (product.getName() != null) {
      if (product.getName().equals("Cup")) {
        System.out.println("Cup!");
      }
    }

    // changed to
    message = Optional.ofNullable(product.getName())
        .filter(name -> name.contains("tea"))
        .map(name -> "Product: " + name)
        .orElse("Without tea in name :(");
    System.out.println(message);
  }


}
