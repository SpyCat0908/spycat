package Araiguma.SpyCat.dtos;

import java.util.List;

public record PetInputDTO(
    String color,
    String specie,
    String description,
    String city,
    String state,
    List<String> images,
    LocationInpuDTO location
    
) {
    
}
