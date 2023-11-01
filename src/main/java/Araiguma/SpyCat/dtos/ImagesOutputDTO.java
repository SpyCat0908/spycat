package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.Images;
import Araiguma.SpyCat.Models.Pet;

public record ImagesOutputDTO(
    Long id,
    String url,
    Pet pet
) {
    public ImagesOutputDTO(Images images){
        this(images.getId(), images.getUrl(), images.getPet());
    }
}
