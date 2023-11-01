package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Pet;

public record LocationInpuDTO(
    double longitude,
    double latitude,
    LocalDateTime date,
    Pet pet
){
    
}
