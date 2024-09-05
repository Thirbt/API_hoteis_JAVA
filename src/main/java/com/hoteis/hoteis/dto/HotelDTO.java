package com.hoteis.hoteis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String nome;
    private String cidade;
    private String estado;
    private Double diaria;
    private Double estrelas;
}
