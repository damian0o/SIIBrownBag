package pl.apso.optional.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Optional_4_ifPresent_Test {

  @Test
  public void should_invoke_consumer_code() {
    // given
    List<Boolean> isConsumed = new ArrayList<>();
    Consumer<String> consumer = s -> isConsumed.add(true);

    // when
    Optional.of("some").ifPresent(consumer);

    // then
    assertThat(isConsumed).hasSize(1).containsExactly(true);
  }

  @Test
  public void should_not_invoke_consumer_code() {
    // given
    List<Boolean> isConsumed = new ArrayList<>();
    Consumer<String> consumer = s -> isConsumed.add(true);

    // when
    Optional.<String>empty().ifPresent(consumer);

    // then
    assertThat(isConsumed).isEmpty();
  }

  @Test
  public void should_throw_NullPointerException_when_consumer_is_null() {
    // given
    Consumer<String> consumer = null;

    // when + then
    assertThatThrownBy(
        () -> Optional.of("some").ifPresent(consumer)
    ).isInstanceOf(NullPointerException.class);

  }

}
