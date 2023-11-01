package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Models.Message;

public record CommentInputDTO(
    List<Message> messages
) {
    
}
