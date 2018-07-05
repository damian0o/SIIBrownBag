package pl.apso.optional.parsing;

import java.util.Optional;

public class ParserUtils {

  public static Optional<Integer> toInt(String in) {
    try {
      return Optional.of(Integer.parseInt(in));
    } catch (NumberFormatException e) {

      // Integer.parseInt throw only NumberFormatException for all possible cases
      /**
       * if (s == null) {
       *    throw new NumberFormatException("null");
       * }
       * if (radix < Character.MIN_RADIX) {
       *    throw new NumberFormatException("radix " + radix +
       *                                             " less than Character.MIN_RADIX");
       * }
       * if (radix > Character.MAX_RADIX) {
       *    throw new NumberFormatException("radix " + radix +
       *                                             " greater than Character.MAX_RADIX");
       * }
       */
      return Optional.empty();
    }
  }

}
