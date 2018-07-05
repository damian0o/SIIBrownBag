package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Optional_8_orElse_Test {

  @Test
  public void should_return_wrapped_value() {
    // given
    var some = Optional.of("some");
    // when
    var result = some.orElse("Other");
    // then
    assertThat(result).isEqualTo("some");
  }

  @Test
  public void should_return_default_value() {
    // given
    var some = Optional.empty();
    // when
    var result = some.orElse("Other");
    // then
    assertThat(result).isEqualTo("Other");
  }



}
