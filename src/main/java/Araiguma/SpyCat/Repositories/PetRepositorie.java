package Araiguma.SpyCat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Araiguma.SpyCat.Models.Pet;

public interface PetRepositorie extends JpaRepository<Pet, Long> {
    
}
