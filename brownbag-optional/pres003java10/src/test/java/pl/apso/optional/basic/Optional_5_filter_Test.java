package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_5_filter_Test {

  @Test
  public void should_filter_with_given_predicate() {
    // given
    var o1 = Optional.of("some");
    var predicate = new Predicate<String>() {
      @Override
      public boolean test(String s) {
        return "some".equals(s);
      }
    };
    // when
    var r1 = o1.filter(predicate);

    // then
    assertThat(r1).contains("some");
  }

  @Test
  public void should_return_empty_when_predicate_not_match() {
    // given
    var o1 = Optional.of("other");
    var predicate = new Predicate<String>() {
      @Override
      public boolean test(String o) {
        return "some".equals(o);
      }
    };
    // when
    Optional<String> r1 = o1.filter(predicate);
    // then
    assertThat(r1).isEmpty();
  }

  @Test
  public void should_throws_NullPointerException_when_null_predicate() {
    // given
    var o1 = Optional.of("some");
    var predicate = (Predicate<String>) null;
    // when + then
    assertThatThrownBy(() -> o1.filter(predicate)).isInstanceOf(NullPointerException.class);
  }

}
