package Araiguma.SpyCat.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import Araiguma.SpyCat.dtos.CommentInputDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    
    private String text;
    private LocalDateTime date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Pet pet;


    public Comment(CommentInputDTO dto){
        this.id = dto.id();
        this.user = dto.user();
        this.text = dto.text();
        this.date = dto.date();
        this.pet = dto.pet();
    }
    
}
