package pl.apso.optional.modeling;

public class DriverRepository {

  public Driver findById(Long id) {
    Insurance insurance = new Insurance("some");
    Car car = new Car(insurance);
    return new Driver(car);
  }

}
