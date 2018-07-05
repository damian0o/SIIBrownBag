package pl.apso.optional.basic2;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Optional_3_combine_Test {

  public Optional<Integer> sumOrEmptyIfBothEmpty(Optional<Integer> a, Optional<Integer> b) {
    return a.map(x -> Optional.of(x + b.orElse(0))).orElse(b);
  }

  @Test
  public void how_to_combine_two_optionals() {
    assertThat(sumOrEmptyIfBothEmpty(Optional.of(2), Optional.of(2))).contains(4);
    assertThat(sumOrEmptyIfBothEmpty(Optional.of(2), Optional.empty())).contains(2);
    assertThat(sumOrEmptyIfBothEmpty(Optional.empty(), Optional.of(2))).contains(2);
    assertThat(sumOrEmptyIfBothEmpty(Optional.empty(), Optional.empty())).isEmpty();
  }

  public Optional<Integer> sumOrEmptyIfBothEmptyReadable(Optional<Integer> a, Optional<Integer> b) {
    if (!a.isPresent() && !b.isPresent()) {
      return Optional.empty();
    }
    return Optional.of(a.orElse(0) + b.orElse(0));
  }

  @Test
  public void how_to_combine_two_optionals_readable() {
    assertThat(sumOrEmptyIfBothEmptyReadable(Optional.of(2), Optional.of(2))).contains(4);
    assertThat(sumOrEmptyIfBothEmptyReadable(Optional.of(2), Optional.empty())).contains(2);
    assertThat(sumOrEmptyIfBothEmptyReadable(Optional.empty(), Optional.of(2))).contains(2);
    assertThat(sumOrEmptyIfBothEmptyReadable(Optional.empty(), Optional.empty())).isEmpty();
  }


  public Optional<Integer> sumIfBothPresent(Optional<Integer> a, Optional<Integer> b) {
    return a.flatMap(x -> b.map(y -> x + y));
  }

  @Test
  public void check_if_both_present() {
    Optional<Integer> v1 = sumIfBothPresent(Optional.of(2), Optional.of(2));
    assertThat(v1).contains(4);

    Optional<Integer> v2 = sumIfBothPresent(Optional.of(2), Optional.empty());
    assertThat(v2).isEmpty();

    Optional<Integer> v3 = sumIfBothPresent(Optional.empty(), Optional.of(2));
    assertThat(v3).isEmpty();

    Optional<Integer> v4 = sumIfBothPresent(Optional.empty(), Optional.empty());
    assertThat(v4).isEmpty();
  }

  public Optional<Integer> sumIfBothPresentReadable(Optional<Integer> a, Optional<Integer> b) {
    if(a.isPresent() && b.isPresent()) {
      return Optional.of(a.get() + b.get());
    }
    return Optional.empty();
  }

  @Test
  public void check_if_both_present_readable() {
    Optional<Integer> v1 = sumIfBothPresentReadable(Optional.of(2), Optional.of(2));
    assertThat(v1).contains(4);

    Optional<Integer> v2 = sumIfBothPresentReadable(Optional.of(2), Optional.empty());
    assertThat(v2).isEmpty();

    Optional<Integer> v3 = sumIfBothPresentReadable(Optional.empty(), Optional.of(2));
    assertThat(v3).isEmpty();

    Optional<Integer> v4 = sumIfBothPresentReadable(Optional.empty(), Optional.empty());
    assertThat(v4).isEmpty();
  }


}
