package kg.mega.trainvoyage.services.Impl;

import jakarta.persistence.EntityNotFoundException;
import kg.mega.trainvoyage.mappers.PassengerMapper;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.repositories.PassengerRepo;
import kg.mega.trainvoyage.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepo passengerRepo;
//    private final PassengerMapper  passengerMapper = PassengerMapper.INSTANCE;

    public PassengerServiceImpl(PassengerRepo passengerRepo) {
        this.passengerRepo = passengerRepo;
    }

    @Override
    public Passenger findById(Long id) {

        return passengerRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found"));

    }

    @Override
    public Passenger create(Passenger passenger) {
        return passengerRepo.save(passenger);
    }
}
