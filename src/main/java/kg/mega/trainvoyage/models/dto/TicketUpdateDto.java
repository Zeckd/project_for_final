package kg.mega.trainvoyage.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kg.mega.trainvoyage.enums.Delete;

public record TicketUpdateDto (
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")
        Long id,
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")
        long passenger,
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")

        long voyage,
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")

        long carriage,
        Delete delete
){
}
