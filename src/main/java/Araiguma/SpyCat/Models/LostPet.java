package Araiguma.SpyCat.Models;

import Araiguma.SpyCat.dtos.LostPetInputDTO;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LostPet extends Pet {
    private String phone;
    private String email;
    
    
    public LostPet(LostPetInputDTO dto){
        this.id = dto.id();
        this.description = dto.description();
        this.city = dto.city();
        this.state = dto.state();
        this.email = dto.email();
        this.phone = dto.phone();
        this.color = dto.color();
        this.specie = dto.specie();
    }

  
}
