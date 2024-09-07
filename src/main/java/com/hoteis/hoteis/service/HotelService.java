package com.hoteis.hoteis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteis.hoteis.dto.HotelDTO;
import com.hoteis.hoteis.exception.NotFoundError;
import com.hoteis.hoteis.models.Hotel;
import com.hoteis.hoteis.repository.HotelRepository;
import com.hoteis.hoteis.service.contracts.HotelServiceContract;

@Service
public class HotelService implements HotelServiceContract{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> obterTodosHoteis() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel obterPorId(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            return hotel.get();
        }else{
            throw new NotFoundError("Não foi possível encontrar o hotel com o ID: " + id);
        }
    }

    @Override
    public Hotel inserirHotel(HotelDTO hotelDTO) {
        Hotel hotel = Hotel.builder()
        .nome(hotelDTO.getNome())
        .cidade(hotelDTO.getCidade())
        .estado(hotelDTO.getEstado())
        .diaria(hotelDTO.getDiaria())
        .estrelas(hotelDTO.getEstrelas())
        .build();
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel editarHotel(Long id, HotelDTO hotelDTO) {
        Hotel hotelEncontrado = this.obterPorId(id);
        Hotel hotelEditado = Hotel.builder()
        .id(hotelEncontrado.getId())
        .nome(hotelDTO.getNome())
        .cidade(hotelDTO.getCidade())
        .estado(hotelDTO.getEstado())
        .diaria(hotelDTO.getDiaria())
        .estrelas(hotelDTO.getEstrelas())
        .build();
        return hotelRepository.save(hotelEditado);
    }

    @Override
    public void deletarHotel(Long id) {
        Hotel hotelEncontrado = this.obterPorId(id);
        hotelRepository.deleteById(hotelEncontrado.getId());
    }
}
