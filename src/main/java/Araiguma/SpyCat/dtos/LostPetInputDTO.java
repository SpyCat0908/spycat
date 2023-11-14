package Araiguma.SpyCat.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record LostPetInputDTO(
    @NotBlank
    String description,
    @NotBlank
    String city,
    @NotBlank
    String state,
    @NotBlank
    String email,
    @NotBlank
    String phone,
    @NotBlank
    String color,
    @NotBlank
    String specie,
    @NotEmpty
    LocationInputDTO location
) {
    
}
