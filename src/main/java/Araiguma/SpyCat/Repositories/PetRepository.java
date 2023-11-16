package Araiguma.SpyCat.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Araiguma.SpyCat.Enum.Status;
import Araiguma.SpyCat.Models.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    public List<Pet> findByStatusNotLike(Status status);
}
