package pl.apso.optional.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_5_filter_Test {

  @Test
  public void should_filter_with_given_predicate() {
    // given
    Optional<String> o1 = Optional.of("some");
    Predicate<String> predicate = s -> "some".equals(s);
    // when
    Optional<String> r1 = o1.filter(predicate);

    // then
    assertThat(r1).contains("some");
  }

  @Test
  public void should_return_empty_when_predicate_not_match() {
    // given
    Optional<String> o1 = Optional.of("other");
    Predicate<String> predicate = s -> "some".equals(s);
    // when
    Optional<String> r1 = o1.filter(predicate);
    // then
    assertThat(r1).isEmpty();
  }

  @Test
  public void should_throws_NullPointerException_when_null_predicate() {
    // given
    Optional<String> o1 = Optional.of("some");
    Predicate<String> predicate = null;
    // when + then
    assertThatThrownBy(() ->o1.filter(predicate)).isInstanceOf(NullPointerException.class);
  }

}
