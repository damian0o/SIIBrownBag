package pl.apso.optional.basic;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class Optional_1_ofNullable_Test {

  @Test
  public void should_wrap_with_optional() {
    var some = Optional.ofNullable("Some");
    assertThat(some).contains("Some");
  }

  @Test
  public void should_wrap_with_empty_optional() {
    var some = Optional.ofNullable((String) null);
    assertThat(some).isEqualTo(Optional.empty());
    assertThat(some == Optional.<String>empty()).isTrue();
  }

}
