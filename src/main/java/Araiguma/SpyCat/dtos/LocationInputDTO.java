package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;


public record LocationInputDTO(
    @NotNull
    double longitude,
    @NotNull
    double latitude,
    @NotNull
    LocalDateTime date
){
    
}
