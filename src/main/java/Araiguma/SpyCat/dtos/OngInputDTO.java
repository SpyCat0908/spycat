package Araiguma.SpyCat.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OngInputDTO(
    @NotBlank
    String tradingName,
    @NotBlank
    @Min(14)
    @Max(14)
    String cnpj,
    @NotBlank
    String phone,
    @NotBlank
    @Email
    String email
) {}
