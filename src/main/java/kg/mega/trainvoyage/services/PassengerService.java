package kg.mega.trainvoyage.services;

import kg.mega.trainvoyage.models.Passenger;

public interface PassengerService {
    Passenger findById(Long id);

    Passenger create(Passenger passenger);
}
