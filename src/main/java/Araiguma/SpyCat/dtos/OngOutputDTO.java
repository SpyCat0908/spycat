package Araiguma.SpyCat.dtos;

import Araiguma.SpyCat.Models.Ong;

public record OngOutputDTO(
    Long id,
    String tradingName,
    String cnpj,
    String phone,
    String email
)
 {
    public OngOutputDTO(Ong ong){
        this(ong.getId(), ong.getTradingName(), ong.getPhone(), ong.getEmail(), ong.getCnpj());
    }
 }
