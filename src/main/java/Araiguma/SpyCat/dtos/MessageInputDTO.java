package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.User;

public record MessageInputDTO(
    User user,
    String text,
    LocalDateTime date,
    Comment comment
) {
    
}
