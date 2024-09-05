package com.hoteis.hoteis.service.contracts;

import com.hoteis.hoteis.dto.HotelDTO;
import com.hoteis.hoteis.models.Hotel;
import java.util.List;

public interface HotelServiceContract {
    List<Hotel> obterTodosHoteis();
    Hotel obterPorId(Long id);
    Hotel inserirHotel(HotelDTO hotelDTO);
    Hotel editarHotel(Long id, HotelDTO hotelDTO);
    void deletarHotel(Long id);
}
