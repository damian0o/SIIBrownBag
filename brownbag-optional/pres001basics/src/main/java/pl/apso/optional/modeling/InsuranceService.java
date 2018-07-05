package pl.apso.optional.modeling;

import java.util.Optional;

class NotFoundException extends Exception {

}

class InsuranceExpired extends Exception {

}

public class InsuranceService {

  public Optional<InsuranceInfo> getInfo(String insuraceNumber) {
    return Optional.of(new InsuranceInfo(Optional.of("Some description")));
  }

  public Optional<InsuranceInfo> getInfoWithExceptions(String insuraceNumber) throws NotFoundException, InsuranceExpired {
    return Optional.of(new InsuranceInfo(Optional.of("Some description")));
  }

}
