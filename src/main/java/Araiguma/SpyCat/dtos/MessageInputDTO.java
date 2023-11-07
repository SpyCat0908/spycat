package Araiguma.SpyCat.dtos;

import java.time.LocalDateTime;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MessageInputDTO(
    @NotNull
    User user,
    @NotBlank
    String text,
    @NotNull
    LocalDateTime date,
    @NotNull
    CommentInputDTO comment
) {
    
}
