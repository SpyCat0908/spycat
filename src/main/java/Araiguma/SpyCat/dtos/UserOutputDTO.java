package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.User;

public record UserOutputDTO(
    Long id, 
    String username, 
    String state,
    String email, 
    String city
) {
    public UserOutputDTO(User user){
        this(user.getId(), user.getUsername(), user.getState(), user.getEmail(), user.getCity());
    }
}