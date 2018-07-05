package pl.apso.optional.basic;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_3_get_Test {

  @Test
  public void should_return_wrapped_value() {
    // given
    var some = Optional.of("some");

    // when
    String uut = some.get();

    // then
    Assertions.assertThat(uut).isNotBlank().isEqualTo("some");
  }

  @Test
  public void should_throw_NoSuchElementException_for_empty() {
    // given
    var some = Optional.empty();

    // when + then
    assertThatThrownBy(() -> some.get()).isInstanceOf(NoSuchElementException.class);
  }

}
