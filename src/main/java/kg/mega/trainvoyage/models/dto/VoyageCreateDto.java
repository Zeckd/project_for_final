package kg.mega.trainvoyage.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record VoyageCreateDto(@JsonFormat(pattern = "dd.MM.yyyy")
                              LocalDate sendDate,
                              @JsonFormat(pattern = "HH:mm")
                              LocalTime sendTime,
                              @JsonProperty("destination_point_id")
                              @NotNull(message = "Значение не должно быть null")
                              @Positive(message = "Только положительные значения (>0)")
                              long destinationPointId,
                              @JsonProperty("starting_point_id")
//                            @JsonIgnore
                              @NotNull(message = "Значение не должно быть null")
                              @Positive(message = "Только положительные значения (>0)")
                              long startingPointId,

                              @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
                              @JsonProperty("arrival_date_time")
                              LocalDateTime arrivalDateTime,
                              @NotNull(message = "Значение не должно быть null")
                              @Positive(message = "Только положительные значения (>0)")
                              long trainId,
                              @NotNull(message = "Значение не должно быть null")
                              @Positive(message = "Только положительные значения (>0)")
                              double distance,
                              @NotNull(message = "Значение не должно быть null")
                              @Positive(message = "Стоимость не должно быть < 0")

                              double price


) {

}
