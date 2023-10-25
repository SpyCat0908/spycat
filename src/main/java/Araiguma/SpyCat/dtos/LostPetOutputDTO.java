package Araiguma.SpyCat.dtos;

public record LostPetOutputDTO(
    Long id,
    String characteristics,
    String description,
    String city,
    String state,
    String email,
    String phone
) {
    
}
