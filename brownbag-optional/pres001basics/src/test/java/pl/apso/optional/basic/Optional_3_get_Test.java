package pl.apso.optional.basic;

import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_3_get_Test {

  @Test
  public void should_return_wrapped_value() {
    // given
    Optional<String> some = Optional.of("some");

    // when
    String uut = some.get();

    // then
    assertThat(uut).isNotBlank().isEqualTo("some");
  }

  @Test
  public void should_throw_NoSuchElementException_for_empty() {
    // given
    Optional<String> some = Optional.empty();

    // when + then
    assertThatThrownBy(() -> some.get()).isInstanceOf(NoSuchElementException.class);
  }

}
