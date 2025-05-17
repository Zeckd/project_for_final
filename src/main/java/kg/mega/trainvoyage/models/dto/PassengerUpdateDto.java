package kg.mega.trainvoyage.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import kg.mega.trainvoyage.enums.Delete;

public record PassengerUpdateDto(
        @NotNull(message = "Значение не должно быть null")
        @Positive(message = "Только положительные значения (>0)")
         Long id,
        @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
        @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
        @NotNull(message = "Значение не должно быть null")
         String lastName,
        @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
        @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
        @NotNull(message = "Значение не должно быть null")
         String firstName,
        @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
        @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
        @NotNull(message = "Значение не должно быть null")
         String patronymic,
        @NotBlank(message = "Строка не должна быть пустой или состоять только из пробелов")
        @NotEmpty(message = "Строка или коллекция не должна быть пустой и не null")
        @NotNull(message = "Значение не должно быть null")
         String address


) {
}
