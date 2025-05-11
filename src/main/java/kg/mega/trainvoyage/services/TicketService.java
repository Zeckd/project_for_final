package kg.mega.trainvoyage.services;

import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;

import java.util.List;

public interface TicketService {
    Ticket create(TicketCreateDto ticketCreateDto);

    List<Ticket> findAll();

    Ticket findById(Long id);
}
