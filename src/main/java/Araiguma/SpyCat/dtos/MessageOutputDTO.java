package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.Message;
import Araiguma.SpyCat.Models.User;

public record MessageOutputDTO(
    Long id,
    User user,
    String text,
    LocalDateTime date,
    CommentOutputDTO comment
) {
    public MessageOutputDTO(Message message){
        this(message.getId(), message.getUser(), message.getText(), message.getDate(), new CommentOutputDTO(message.getComment()));
    }
}
