package kg.mega.trainvoyage.models.dto;

import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Ticket;

import java.util.List;

public record PassengerTicketTransactionDto(
        Passenger passengerId,
        List<TicketTransactionDto> ticketId,
        double totalAmount
){
}
