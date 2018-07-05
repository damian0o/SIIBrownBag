package pl.apso.optional.vavr;

import io.vavr.control.Either;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class EitherExampleTest {


  public static Either<String, Double> divide(int x, int y) {
    if (y == 0) {
      return Either.left("/ by zero");
    }
    double v = 1.0 * x / y;
    return Either.right(v);
  }

  @Test
  public void basic_example() {
    Either<String, Double> result =
        divide(4, 2).mapLeft(e -> e + "!!!");

    Assertions.assertThat(result.right().get()).isEqualTo(2);


    Either<String, Double> failure = divide(4, 0);
    assertEquals("/ by zero", failure.left().get());

  }

}