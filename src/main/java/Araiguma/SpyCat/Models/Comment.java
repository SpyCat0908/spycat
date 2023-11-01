package Araiguma.SpyCat.Models;

import java.util.List;

import Araiguma.SpyCat.dtos.CommentInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "comment")
    private List <Message> messages;
    
    public Comment(CommentInputDTO dto){
        this.messages = dto.messages();
    }
}
