package pl.apso.optional.basic2;

import org.junit.Test;

import java.util.Optional;

public class Optional_1_isPresent_get_Test {

  @Test
  public void example_isPresentWithGet() throws Exception {
    Optional<String> value = Optional.of("some");

    /**
     * this is not the recommended use of Optional
     */
    if (value.isPresent()) {
      System.out.println(value.get());
    }

    // Better
    value.ifPresent(v -> {
      System.out.println(v);
    });

    // Not good
    if(!value.isPresent()) {
      throw new Exception("");
    } else {
      System.out.println(value.get());
    }

    // Better
    System.out.println(value.orElseThrow(() -> new Exception()));

  }


}
