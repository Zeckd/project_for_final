package kg.mega.trainvoyage.models.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PassengerDto (
        String firstName,
        String lastName,
        String patronymic,
        String address

){
}
