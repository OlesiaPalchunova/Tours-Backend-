package com.bd.tours.mapper;

import com.bd.tours.dto.TicketDto;
import com.bd.tours.entity.Ticket;
import com.bd.tours.entity.Tourist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketMapper {
    public TicketDto mapToDTO(Ticket ticket) {
        Tourist tourist = ticket.getTourist();
        TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        if (tourist != null) dto.setTouristId(ticket.getTourist().getId());
        dto.setPrice(ticket.getPrice());
        dto.setCategory(ticket.getCategory());
        dto.setPlace(ticket.getPlace());
        dto.setFlightId(ticket.getFlight().getId());
        return dto;
    }

    public List<TicketDto> mapListToDTO(List<Ticket> tickets) {
        return tickets.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
