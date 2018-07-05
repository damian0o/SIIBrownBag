package pl.apso.optional.basic2;

import org.junit.Test;

import java.io.*;
import java.util.Optional;

public class Optional_5_serialization_Test {
  static class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    Optional<Integer> value = Optional.empty();

    public void setValue(Integer i) {
      this.value = Optional.of(i);
    }

    public Optional<Integer> getValue() {
      return value;
    }
  }

  @Test(expected = NotSerializableException.class)
  public void serialize() {
    Message my = new Message();
    byte[] bytes = toBytes(my);
  }

  public static <T extends Serializable> byte[] toBytes(T reportInfo) {
    try (ByteArrayOutputStream bstream = new ByteArrayOutputStream()) {
      try (ObjectOutputStream ostream = new ObjectOutputStream(bstream)) {
        ostream.writeObject(reportInfo);
      }
      return bstream.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}