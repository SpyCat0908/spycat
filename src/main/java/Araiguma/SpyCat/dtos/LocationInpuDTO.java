package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Pet;
import jakarta.validation.constraints.NotNull;

public record LocationInpuDTO(
    @NotNull
    double longitude,
    @NotNull
    double latitude,
    @NotNull
    LocalDateTime date
){
    
}
