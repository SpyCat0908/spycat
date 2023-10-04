package Araiguma.SpyCat.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LostedPet extends Pet {
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;
    
    
}
