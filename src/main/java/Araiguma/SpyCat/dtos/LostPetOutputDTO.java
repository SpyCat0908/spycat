package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.LostPet;

public record LostPetOutputDTO(
    Long id,
    String description,
    String city,
    String state,
    String email,
    String phone
) {
    public LostPetOutputDTO(LostPet lostPet){
        this(lostPet.getId(), lostPet.getState(), lostPet.getPhone(), lostPet.getEmail(), lostPet.getDescription(), lostPet.getCity());
    }
}
