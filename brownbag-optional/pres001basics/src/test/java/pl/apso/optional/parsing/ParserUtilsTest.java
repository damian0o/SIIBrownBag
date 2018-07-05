package pl.apso.optional.parsing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.apso.optional.parsing.ParserUtils.toInt;

public class ParserUtilsTest {

  @Test
  public void toInt_shouldParseInteger() {
    Optional<Integer> parsed = toInt("123");
    assertThat(parsed).contains(123);
  }

  @Test
  public void toInt_shouldReturnEmptyForNullString() {
    Optional<Integer> parsed = toInt(null);
    assertThat(parsed).isEmpty();
  }

  @Test
  public void toInt_List_shouldParseListOfStrings() {
    List<String> elements = Arrays.asList("123", "a", "21", "sd", "ds", "321");

    Stream<Optional<Integer>> optionalStream = elements.stream().map(x -> toInt(x));
    // optionalStream.flatMap(x -> x);

  }

}