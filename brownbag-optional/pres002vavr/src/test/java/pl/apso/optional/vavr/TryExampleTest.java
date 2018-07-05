package pl.apso.optional.vavr;

import io.vavr.control.Try;
import org.junit.Test;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.vavr.API.$;
import static io.vavr.API.Case;

public class TryExampleTest {


  @Test
  public void examples_of_parsing_urls() {
    System.out.println("=====  Example 1");
    testSomeTry("http://example.com/");

    System.out.println("=====  Example 2");
    testSomeTry("http\"://example.com/");

    System.out.println("=====  Example 3");
    testSomeTry("http://e]xample.com/");
  }

  private void testSomeTry(String uri) {
    Try<URI> urlTry = Try.of(() -> URI.create(uri));

    printSomeProperties(urlTry);

    if (urlTry.isSuccess()) {
      System.out.println("Success URI: " + urlTry.get());
    } else {
      System.out.println("Initial Failurue: " + urlTry.getCause().getMessage());
    }

    Try<String> afterRetry = urlTry
        .recover(tryToFixScheme(uri))
        .mapFailure(
            Case($(), new NullPointerException())
        )
        .filter(url -> url.getHost().equals("example.com"))
        .mapTry(url -> url.toURL().getProtocol())
        .recover((a) -> "default://");

    if (afterRetry.isSuccess()) {
      System.out.println(afterRetry.get());
    } else {
      System.out.println(afterRetry.getCause().getMessage());
    }
  }

  private Function<Throwable, URI> tryToFixScheme(String uri) {
    return e -> {
      if (e.getMessage().contains("scheme")) {
        URI fixedScheme = URI.create("http://" + uri.substring(uri.lastIndexOf("//") + 2));
        System.out.println("Fixed schema " + fixedScheme);
        return fixedScheme;
      } else {
        throw new IllegalArgumentException("Can not proccess without sechea", e);
      }
    };
  }

  private void printSomeProperties(Try<URI> urlTry) {
    System.out.println("Is empty: " + urlTry.isEmpty());
    System.out.println("Is failure: " + urlTry.isFailure());
    System.out.println("Is success: " + urlTry.isSuccess());
  }

  @Test
  public void make_use_of_stream_api() {
    Map<Boolean, List<URI>> collect = Try.of(() -> URI.create("4comprehension.com"))
        .collect(Collectors.partitioningBy(URI::isAbsolute));

    System.out.println(collect);

  }

}
