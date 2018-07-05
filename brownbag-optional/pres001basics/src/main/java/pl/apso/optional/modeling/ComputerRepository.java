package pl.apso.optional.modeling;

import java.util.Optional;

public class ComputerRepository {

  public Optional<Computer> findById(Long id) {
    Usb usb = new Usb(Optional.of("some"));
    SoundCard soundCard = new SoundCard(Optional.of(usb));
    Computer computer = new Computer(Optional.of(soundCard));
    return Optional.of(computer);
  }


}
