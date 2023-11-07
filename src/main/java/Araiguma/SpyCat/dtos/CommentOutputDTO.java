package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.Message;
import jakarta.validation.constraints.NotEmpty;

public record CommentOutputDTO(
    @NotEmpty
    List<Message> messages
) {
    public CommentOutputDTO(Comment comment){
        this(comment.getMessages());
    }
}
