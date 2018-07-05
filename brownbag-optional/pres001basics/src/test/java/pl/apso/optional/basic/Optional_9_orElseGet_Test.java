package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class Optional_9_orElseGet_Test {

  @Test
  public void should_return_wrapped_value() {
    // given
    Optional<String> some = Optional.of("some");

    Supplier<String> supplier = () -> "Other";
    // when
    String result = some.orElseGet(supplier);
    // then
    assertThat(result).isEqualTo("some");
  }

  @Test
  public void should_return_default_value() {
    // given
    Optional<String> some = Optional.empty();
    Supplier<String> supplier = () -> "Other";
    // when
    String result = some.orElseGet(supplier);
    // then
    assertThat(result).isEqualTo("Other");
  }

}
