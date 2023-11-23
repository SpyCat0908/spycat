package Araiguma.SpyCat.Models;

import java.time.LocalDate;

import Araiguma.SpyCat.dtos.ImageInputDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private LocalDate date;

    @ManyToOne(optional = false)
    private Pet pet;
    
    public Image(ImageInputDTO dto){
        this.id = dto.id();
        this.url = dto.url();
        this.date = dto.date();
    }
}
