package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Models.Message;
import jakarta.validation.constraints.NotEmpty;

public record CommentInputDTO(
    @NotEmpty
    List<Message> messages
) {
    
}
