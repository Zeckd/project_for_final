package kg.mega.trainvoyage.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kg.mega.trainvoyage.models.Carriage;
import kg.mega.trainvoyage.models.Voyage;

public record TicketTransactionDto(

        Long id,
        Voyage voyage,
        Carriage carriage,
        double price


) {
}
