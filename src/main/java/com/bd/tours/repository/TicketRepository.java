package com.bd.tours.repository;

import com.bd.tours.entity.Flight;
import com.bd.tours.entity.Ticket;
import com.bd.tours.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByFlight(Flight flight);

    List<Ticket> findByTourist(Tourist tourist);
}