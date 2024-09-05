package com.hoteis.hoteis.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tabela_hoteis")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_hotel", length = 100, nullable = false)
    private String nome;
    @Column(name = "cidade_hotel", length = 100, nullable = false)
    private String cidade;
    @Column(name = "estado_hotel", length = 100, nullable = false)
    private String estado;
    @Column(name = "diaria_hotel", nullable = false)
    private Double diaria;
    @Column(name = "estrelas_hotel", nullable = false)
    private Double estrelas;
}
