package kg.mega.trainvoyage.services;

import jakarta.validation.Valid;
import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.dto.PassengerUpdateDto;

import java.util.List;

public interface PassengerService {
    Passenger findById(Long id);

    Passenger create(Passenger passenger);


    List<Passenger> findAllToList(int pageNo, int sizePage);

    List<Passenger> findAll();

    Passenger findPassengerById(Long passenger);

    Passenger update(@Valid PassengerUpdateDto passengerUpdateDto, Delete delete);
}
