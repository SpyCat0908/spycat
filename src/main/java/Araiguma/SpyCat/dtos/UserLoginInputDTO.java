package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.User;

public record UserLoginInputDTO (
    String email,
    String password
){

    // public UserLoginInputDTO(User user){
    //     this(user.getEmail(), user.getPassword());
    // }
    
}
