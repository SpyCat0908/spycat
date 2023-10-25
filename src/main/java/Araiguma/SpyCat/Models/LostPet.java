package Araiguma.SpyCat.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LostPet extends Pet {
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    
    
}
