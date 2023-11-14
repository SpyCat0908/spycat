package Araiguma.SpyCat.dtos;

import java.util.List;

import Araiguma.SpyCat.Models.Pet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PetOutputDTO(
    @NotNull
    Long id,
    @NotBlank
    String description,
    @NotBlank
    String color,
    @NotBlank
    String specie,
    @NotBlank
    String city,
    @NotBlank
    String state,
    @NotEmpty
    List<String> images,
    UserMessageOutputDTO user,
    List<LocationOutputDTO> locations,
    List<CommentOutputDTO> comments
) {
    public PetOutputDTO(Pet pet){
        this(pet.getId(), pet.getState(), pet.getSpecie(), pet.getDescription(), pet.getColor(), pet.getCity(), pet.getImages(), new UserMessageOutputDTO(pet.getUser()),  pet.getLocations().stream().map(location -> new LocationOutputDTO(location)).toList(),  pet.getComments().stream().map(comment -> new CommentOutputDTO(comment)).toList() );
    }
}
