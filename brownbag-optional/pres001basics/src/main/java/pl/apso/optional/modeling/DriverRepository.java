package pl.apso.optional.modeling;

import java.util.HashMap;
import java.util.Map;

public class DriverRepository {

  private static Map<Long, Driver> repo;

  static {
    repo = new HashMap<>();
    repo.put(0L, null);
    repo.put(1L, Driver.builder().build());

    repo.put(2L, Driver.builder().car(
        Car.builder().build()
    ).build());

    repo.put(3L, Driver.builder().car(
        Car.builder().insurance(
            Insurance.builder().build()
        ).build()
    ).build());

    repo.put(4L, Driver.builder().car(
        Car.builder().insurance(
            Insurance.builder().version("some").build()
        ).build()
    ).build());
  }


  public Driver findById(Long id) {
    return repo.getOrDefault(id, repo.get(0L));
  }

}
