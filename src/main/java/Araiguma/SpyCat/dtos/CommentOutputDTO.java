package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentOutputDTO(
    @NotNull
    Long id,
    @NotNull
    User user,
    @NotBlank
    String text,
    @NotNull
    LocalDateTime date

) {
    public CommentOutputDTO(Comment comment){
        this(comment.getId(), comment.getUser(), comment.getText(), comment.getDate());
    }
}
