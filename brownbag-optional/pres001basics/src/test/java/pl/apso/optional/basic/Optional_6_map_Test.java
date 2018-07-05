package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_6_map_Test {

  @Test
  public void should_map_wrapped_value() {
    // given
    Optional<String> some = Optional.of("some");

    Function<String, String> mapper = (s) -> s + "+added";
    // when
    Optional<String> result = some.map(mapper);
    // then
    assertThat(result).contains("some+added");
  }

  @Test
  public void should_remain_empty_after_map_when_already_empty() {
    // given
    Optional<String> some = Optional.empty();
    Function<String, String> mapper = (s) -> s + "+added";
    // when
    Optional<String> result = some.map(mapper);
    // then
    assertThat(result).isEmpty();
  }

  @Test
  public void should_throw_NullPointerException_when_null_predicate() {
    // given
    Optional<String> some = Optional.empty();
    Function<String, String> mapper = null;
    // when + then
    assertThatThrownBy(() -> some.map(mapper)).isInstanceOf(NullPointerException.class);
  }

}
