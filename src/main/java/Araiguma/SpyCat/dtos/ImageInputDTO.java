package Araiguma.SpyCat.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record ImageInputDTO (
    Long id, 
    @NotNull
    String url, 
    @NotNull
    LocalDate date
) {
    
}
