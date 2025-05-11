package kg.mega.trainvoyage.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TicketCreateDto(
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")
        long passenger,
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")

        long voyage,
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")

        long carriage

) {
}
