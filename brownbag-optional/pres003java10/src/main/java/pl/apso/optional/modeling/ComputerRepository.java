package pl.apso.optional.modeling;

import java.util.Optional;

public class ComputerRepository {

  public Optional<Computer> findById(Long id) {
    var usb = Optional.of(new Usb(Optional.of("some")));
    var soundCard = Optional.of(new SoundCard(usb));
    var computer = Optional.of(new Computer(soundCard));
    return computer;
  }


}
