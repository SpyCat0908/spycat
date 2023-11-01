package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Location;
import Araiguma.SpyCat.Models.Pet;

public record LocationOutputDTO(
    Long id,
    double longitude,
    double latitude,
    LocalDateTime date,
    Pet pet
) {
    public LocationOutputDTO(Location location){
        this(location.getId(), location.getLongitude(), location.getLatitude(), location.getDate(), location.getPet());
    }
}
