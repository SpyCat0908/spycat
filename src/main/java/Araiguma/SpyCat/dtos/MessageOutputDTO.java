package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.Message;
import Araiguma.SpyCat.Models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MessageOutputDTO(
    @NotNull
    Long id,
    @NotNull
    User user,
    @NotBlank
    String text,
    @NotNull
    LocalDateTime date,
    @NotNull
    CommentOutputDTO comment
) {
    public MessageOutputDTO(Message message){
        this(message.getId(), message.getUser(), message.getText(), message.getDate(), new CommentOutputDTO(message.getComment()));
    }
}
