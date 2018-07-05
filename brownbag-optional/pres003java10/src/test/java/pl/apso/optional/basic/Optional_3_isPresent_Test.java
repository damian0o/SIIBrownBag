package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Optional_3_isPresent_Test {

  @Test
  public void should_return_true_if_not_null() {
    // given
    var some = Optional.of("some");

    // when + then
    assertThat(some.isPresent()).isTrue();
  }

  @Test
  public void should_return_false_for_empty() {
    // given
    var some = Optional.empty();

    // when + then
    assertThat(some.isPresent()).isFalse();
  }

}
