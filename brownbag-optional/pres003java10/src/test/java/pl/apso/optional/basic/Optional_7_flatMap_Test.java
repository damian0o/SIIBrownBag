package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_7_flatMap_Test {

  @Test
  public void should_map_wrapped_value() {
    // given
    var some = Optional.of("some");

    var mapper = new Function<String, Optional<String>>() {
      @Override
      public Optional<String> apply(String s) {
        return Optional.of(s + "+added");
      }
    };

    // when
    var result = some.flatMap(mapper);
    // then
    assertThat(result).contains("some+added");
  }

  @Test
  public void should_return_empty_when_predicate_return_empty() {
    // given
    var some = Optional.of("some");

    var mapper = new Function<String, Optional<String>>() {
      @Override
      public Optional<String> apply(String s) {
        return Optional.empty();
      }
    };
    // when
    var result = some.flatMap(mapper);
    // then
    assertThat(result).isEmpty();
  }

  @Test
  public void should_remain_empty_after_map_when_already_empty() {
    // given
    var some = Optional.<String>empty();
    var mapper = new Function<String, Optional<String>>() {
      @Override
      public Optional<String> apply(String s) {
        return Optional.of(s + "+added");
      }
    };

    // when
    Optional<String> result = some.flatMap(mapper);
    // then
    assertThat(result).isEmpty();
  }

  @Test
  public void should_throw_NullPointerException_when_null_predicate() {
    // given
    var some = Optional.<String>empty();
    var mapper = (Function<String, Optional<String>>) null;
    // when + then
    assertThatThrownBy(() -> some.flatMap(mapper)).isInstanceOf(NullPointerException.class);
  }


}
