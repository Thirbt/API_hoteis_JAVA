package com.hoteis.hoteis.dto.erroDTO;

import lombok.Getter;

@Getter
public class ErrorDTO {
    private String error;

    public ErrorDTO(String error){
        this.error = error;
    }
}
