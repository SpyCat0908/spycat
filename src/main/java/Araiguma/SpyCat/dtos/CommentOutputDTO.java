package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.Message;

public record CommentOutputDTO(
    List<Message> messages
) {
    public CommentOutputDTO(Comment comment){
        this(comment.getMessages());
    }
}