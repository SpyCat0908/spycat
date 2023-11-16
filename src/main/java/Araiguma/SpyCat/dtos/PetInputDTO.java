package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Enum.Status;
import Araiguma.SpyCat.Models.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PetInputDTO(
    @NotBlank
    Long id,
    @NotBlank
    String color,
    @NotBlank
    String specie,
    @NotBlank
    String description,
    @NotBlank
    String city,
    @NotBlank
    String state,
    @NotBlank
    @Enumerated(EnumType.STRING)
    Status status,
    @NotEmpty
    List<String> images,
    @NotNull
    LocationInputDTO location,
    User user
    
) {
    
}
