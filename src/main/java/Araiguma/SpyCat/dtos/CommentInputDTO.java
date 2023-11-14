package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Pet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentInputDTO(
    @NotNull
    UserInputDTO user,
    @NotBlank
    String text,
    @NotNull
    LocalDateTime date,
    Pet pet
) {
    
}
