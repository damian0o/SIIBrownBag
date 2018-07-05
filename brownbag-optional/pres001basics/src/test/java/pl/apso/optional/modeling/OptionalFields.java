package pl.apso.optional.modeling;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionalFields {

  public static final String NO_INSURANCE = "No insurance";
  public static final String FOUND_BUT_WAS_EMPTY = "FOUND_BUT_WAS_EMPTY";
  public static final String NOT_VALID_DESCRIPTION = "NOT_VALID_DESCRIPTION";
  DriverRepository driverRepository = new DriverRepository();

  @Test
  public void old_fashioned_null_checks() {
    // given
    Driver driver = driverRepository.findById(4L);

    // when
    String insuranceNumber = getInsuranceNumber(driver);

    // then
    assertThat(insuranceNumber).isEqualTo("some");
  }

  private String getInsuranceNumber(Driver driver) {
    if (driver != null) {
      Car car = driver.getCar();
      if (car != null) {
        Insurance insurance = car.getInsurance();
        if (insurance != null) {
          String version = insurance.getVersion();
          if (version != null) {
            return version;
          }
        }
      }
    }
    return "Default";
  }

  ComputerRepository computerRepository = new ComputerRepository();

  @Test
  public void new_better_optional_aproach() {

    Optional<Computer> computer = computerRepository.findById(1L);

    String result = computer
        .flatMap(Computer::getSoundCard)
        .flatMap(SoundCard::getUsb)
        .flatMap(Usb::getVersion)
        .orElse("Default");

    assertThat(result).isEqualTo("some");
  }

  @Test
  public void butNothingIsLost_shouldReturnSome() {
    // given
    Optional<Driver> driver = Optional.of(driverRepository.findById(4L));

    // when
    String insuranceNumber = driver
        .map(Driver::getCar)
        .map(Car::getInsurance)
        .map(Insurance::getVersion)
        .orElse("Default");

    // then
    assertThat(insuranceNumber).isEqualTo("some");
  }

  @Test
  public void butNothingIsLost_shouldReturnDefault() {
    // given
    Optional<Driver> driver = Optional.of(driverRepository.findById(1L));

    // when
    String insuranceNumber = driver
        .map(Driver::getCar)
        .map(Car::getInsurance)
        .map(Insurance::getVersion)
        .orElse("Default");

    // then
    assertThat(insuranceNumber).isEqualTo("Default");
  }

  // Alternatives
  // Groovy -> myMap.?keyA.?keyB.?keyC
  // Kotlin -> bob?.department?.head?.name


  InsuranceService insuranceService = new InsuranceService();

  @Test
  public void everythin_bad_starts_when_we_are_tempted_by_fluent_api() throws Exception {

    Optional<Long> driverId = Optional.of(4L);

    String insuranceInfo = driverId
        .map(driverRepository::findById)
        .map(Driver::getCar)
        .map(Car::getInsurance)
        .map(Insurance::getVersion)
        .flatMap(insuranceService::getInfo)
        .flatMap(InsuranceInfo::getDescription)
        .orElse(NO_INSURANCE);

    if (NO_INSURANCE.equals(insuranceInfo)) {
      throw new Exception("Something went wrong");
    } else {
      System.out.println("Everything ok");
    }

  }

  @Test
  public void what_if_we_have_some_catch_exceptions() throws Exception {

    Optional<Long> driverId = Optional.of(4L);

    Function<String, InsuranceInfo> getInsuranceInfo = x -> {
      try {
        Optional<InsuranceInfo> info = insuranceService.getInfoWithExceptions(x);
        if (info.isPresent()) {
          return info.get();
        }
        return new InsuranceInfo(Optional.of(FOUND_BUT_WAS_EMPTY));
      } catch (NotFoundException e) {
        // log.warn("No info for insurance");
      } catch (InsuranceExpired e) {
        // log.error("very shity situation");
      }
      return new InsuranceInfo(Optional.of(NOT_VALID_DESCRIPTION));
    };

    // Wiele scieżek zdefiniowanych jest niejawnie.
    // Nie wspominając o wyjątkach runtimowych. Timeout (connection, read), server not found
    // W mikroserwisach takie sytuacje nie są wyjątkowe.
    String insuranceInfo = driverId
        .map(driverRepository::findById)
        .map(Driver::getCar)
        .map(Car::getInsurance)
        .map(Insurance::getVersion)
        .map(getInsuranceInfo)
        .flatMap(InsuranceInfo::getDescription)
        .orElse(NO_INSURANCE);

    if (NO_INSURANCE.equals(insuranceInfo)) {
      throw new Exception("Something went wrong");
    } else if (FOUND_BUT_WAS_EMPTY.equals(insuranceInfo)) {

    } else if (NOT_VALID_DESCRIPTION.equals(insuranceInfo)) {

    } else {
      System.out.println("Everything ok");
    }

  }

}
