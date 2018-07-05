package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_1_of_Test {

  @Test
  public void should_wrap_with_optional() {
    var some = Optional.of("Some");
    assertThat(some).contains("Some");
  }

  @Test
  public void should_throw_invalid_argument_exception_for_null() {
    assertThatThrownBy(() -> Optional.of(null))
        .isInstanceOf(NullPointerException.class);
  }

}
