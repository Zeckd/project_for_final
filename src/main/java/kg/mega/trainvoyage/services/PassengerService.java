package kg.mega.trainvoyage.services;

import kg.mega.trainvoyage.models.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger findById(Long id);

    Passenger create(Passenger passenger);


    List<Passenger> findAllToList(int pageNo, int sizePage);

    List<Passenger> findAll();
}
