package Araiguma.SpyCat.Models;

import java.time.LocalDateTime;

import Araiguma.SpyCat.dtos.MessageInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(optional = false)
    private User user;
    private String text;
    private LocalDateTime date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Message(MessageInputDTO dto){
        this.user = dto.user();
        this.text = dto.text();
        this.date = dto.date();
        this.comment = new Comment(dto.comment());
    }
    
}
