package Araiguma.SpyCat.dtos;

import java.time.LocalDate;

import Araiguma.SpyCat.Models.Image;
import jakarta.validation.constraints.NotNull;

public record ImageOutputDTO (
    @NotNull
    Long id, 
    @NotNull
    String url, 
    @NotNull
    LocalDate date
){

    public ImageOutputDTO(Image image){
        this(image.getId(), image.getUrl(), image.getDate());
    }
    
}
