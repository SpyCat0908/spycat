package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Models.Pet;

public record PetOutputDTO(
    Long id,
    String description,
    String color,
    String specie,
    String city,
    String state,
    List<String> images
) {
    public PetOutputDTO(Pet pet){
        this(pet.getId(), pet.getState(), pet.getSpecie(), pet.getDescription(), pet.getColor(), pet.getCity(), pet.getImages());
    }
}
