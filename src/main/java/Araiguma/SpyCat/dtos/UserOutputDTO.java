package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.User;

public record UserOutputDTO(
    Long id, 
    String email, 
    String username, 
    String city,
    String state
) {
    public UserOutputDTO(User user){
        this(user.getId(), user.getUsername(), user.getState(), user.getEmail(), user.getCity());
    }
}