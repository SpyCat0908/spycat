package Araiguma.SpyCat.Models;

import java.time.LocalDateTime;

import Araiguma.SpyCat.dtos.LocationInpuDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Location{
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double longitude;
    private double latitude;
    private LocalDateTime date;
    @ManyToOne(optional=true)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Location(LocationInpuDTO dto){
        this.longitude = dto.latitude();
        this.latitude = dto.latitude();
        this.date = dto.date();
        this.pet = dto.pet();
    }

}
