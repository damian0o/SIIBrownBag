package pl.apso.optional.basic2;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class Optional_2_orElse_vs_orElseGet {

  static Integer counter = 0;

  static class Foo {
  }

  static Foo callApi() {
    counter++;
    return new Foo();
  }

  @Before
  public void reset() {
    counter = 0;
  }

  @Test
  public void how_many_object_will_be_created_empty_orElse() {
    Optional.<Foo>empty().orElse(callApi());
    SoftAssertions softly = new SoftAssertions();

    softly.assertThat(counter).isEqualTo(0);
    softly.assertThat(counter).isEqualTo(1);
    softly.assertThat(counter).isEqualTo(2);

    softly.assertAll();
  }

  @Test
  public void how_many_object_will_be_created_empty_orElseGet() {
    Optional.<Foo>empty().orElseGet(Optional_2_orElse_vs_orElseGet::callApi);
    SoftAssertions softly = new SoftAssertions();

    softly.assertThat(counter).isEqualTo(0);
    softly.assertThat(counter).isEqualTo(1);
    softly.assertThat(counter).isEqualTo(2);

    softly.assertAll();
  }

  @Test
  public void how_many_object_will_be_created_present_orElse() {
    Optional.of(new Foo()).orElse(callApi());
    SoftAssertions softly = new SoftAssertions();

    softly.assertThat(counter).isEqualTo(0);
    softly.assertThat(counter).isEqualTo(1);
    softly.assertThat(counter).isEqualTo(2);

    softly.assertAll();
  }

  @Test
  public void how_many_object_will_be_created_present_orElseGet() {
    Optional.of(new Foo()).orElseGet(Optional_2_orElse_vs_orElseGet::callApi);
    SoftAssertions softly = new SoftAssertions();

    softly.assertThat(counter).isEqualTo(0);
    softly.assertThat(counter).isEqualTo(1);
    softly.assertThat(counter).isEqualTo(2);

    softly.assertAll();
  }

}
