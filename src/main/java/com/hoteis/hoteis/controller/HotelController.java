package com.hoteis.hoteis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteis.hoteis.dto.HotelDTO;
import com.hoteis.hoteis.models.Hotel;
import com.hoteis.hoteis.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/hotel", produces = {"application/json"})
@Tag(name = "Hoteis")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;
    
    @GetMapping
    @Operation(summary = "Realiza a busca de todos os Hoteis", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    public List<Hotel> obterTodosHoteis(){
        return hotelService.obterTodosHoteis();
    }

    @GetMapping("{id}")
    @Operation(summary = "Realiza a busca de um Hotel por ID", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Hotel não encontrado")
    })
    public Hotel obterPorId(@PathVariable Long id){
        return hotelService.obterPorId(id);
    }

    @PostMapping
    @Operation(summary = "Realiza a inserção de um Hotel novo", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inserção realizada com sucesso")
    })
    public Hotel inserirHotel(@RequestBody HotelDTO hotelDTO){
        return hotelService.inserirHotel(hotelDTO);
    }

    @PutMapping("{id}")
    @Operation(summary = "Realiza a atualização de um Hotel por ID", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Edição realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Hotel não encontrado para edição")
    })
    public Hotel editarHotel(@PathVariable Long id, @RequestBody HotelDTO hotelDTO){
        return hotelService.editarHotel(id, hotelDTO);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Realiza a deleção de um Hotel por ID", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Hotel não encontrado para deleção")
    })
    public void deletarHotel(@PathVariable Long id){
        hotelService.deletarHotel(id);
    }
}
