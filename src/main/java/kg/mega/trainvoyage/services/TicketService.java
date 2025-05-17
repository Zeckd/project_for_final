package kg.mega.trainvoyage.services;

import jakarta.validation.Valid;
import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.dto.PassengerTicketTransactionDto;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;
import kg.mega.trainvoyage.models.dto.TicketUpdateDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    Ticket create(TicketCreateDto ticketCreateDto);

    List<Ticket> findAll();

    Ticket findById(Long id);

    List<Ticket> findAllToList(int pageNo, int sizePage);

    Ticket findTicketById(Long ticket);

    List<Ticket> findAllTransactionsById(Long passengerId, Pageable pageable);

    PassengerTicketTransactionDto getAllPassengerTransactionsById(Long passengerId, int pageNo, int pageSize);

    Ticket update(@Valid TicketUpdateDto ticketUpdateDto, Delete delete);
}
