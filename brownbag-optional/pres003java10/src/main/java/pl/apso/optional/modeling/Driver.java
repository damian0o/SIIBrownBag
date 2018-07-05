package pl.apso.optional.modeling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {
  Car car;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Car {
  Insurance insurance;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Insurance {
  String version;
}
