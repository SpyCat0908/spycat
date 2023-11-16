package Araiguma.SpyCat.dtos;

public record LostPetUpdateInputDTO(
    Long id,
    String description,
    String city,
    String state,
    String email,
    String phone,
    String color,
    String specie,
    LocationInputDTO location

) {
    
}
