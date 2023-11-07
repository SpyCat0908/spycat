package Araiguma.SpyCat.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserInputDTO(
    @NotNull
    Long id,
    @NotBlank
    String username,
    @NotBlank
    String password,
    @NotBlank
    @Email
    String email
){}
