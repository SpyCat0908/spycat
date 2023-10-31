package Araiguma.SpyCat.Models;

import java.util.List;

import Araiguma.SpyCat.dtos.PetInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    protected long id;
    protected String color;
    protected String specie;
    protected String description;
    protected String city;
    protected String state;
    @Enumerated(EnumType.STRING)
    protected Status status;
    @OneToMany(mappedBy = "pet")
    protected List<Location> locations;
    protected List<String> images;
    @ManyToOne
    @JoinColumn(name ="user_id")
    protected User user;
    @OneToOne(optional = true)
    protected Comment comment;

    
    public Pet(PetInputDTO dto){
        this.color = dto.color();
        this.specie = dto.specie();
        this.description = dto.description();
        this.city = dto.city();
        this.state = dto.state();
        this.images = dto.images();
    }


}
