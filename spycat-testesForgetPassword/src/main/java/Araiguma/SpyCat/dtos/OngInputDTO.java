package Araiguma.SpyCat.dtos;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record OngInputDTO(
    Long id,
    @NotBlank
    String tradingName,
    @NotBlank
    
    @CNPJ
    String cnpj,
    @NotBlank
    String phone,
    @NotBlank
    @Email
    String email,
    @NotEmpty
    LocationInputDTO location
) {}
