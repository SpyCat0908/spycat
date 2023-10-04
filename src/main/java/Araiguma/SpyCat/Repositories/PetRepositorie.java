package Araiguma.SpyCat.Repositories;

import org.springframework.data.repository.CrudRepository;

import Araiguma.SpyCat.Models.Pet;

public interface PetRepositorie extends CrudRepository<Pet, Long> {
    
}
