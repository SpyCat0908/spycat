package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserOutputDTO(
    @NotNull
    Long id,
    @NotBlank 
    String username,
    @NotBlank 
    String state,
    @NotBlank
    @Email
    String email,
    @NotBlank 
    String city
) {
    public UserOutputDTO(User user){
        this(user.getId(), user.getUsername(), user.getState(), user.getEmail(), user.getCity());
    }
}