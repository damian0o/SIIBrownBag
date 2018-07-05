package pl.apso.optional.modeling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer {
  private Optional<SoundCard> soundCard;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class SoundCard {
  private Optional<Usb> usb;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Usb {
  private Optional<String> version;
}
