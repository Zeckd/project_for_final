package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.mappers.PassengerMapper;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.dto.PassengerUpdateDto;
import kg.mega.trainvoyage.repositories.PassengerRepo;
import kg.mega.trainvoyage.services.PassengerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Override
    public List<Passenger> findAllToList(int pageNo, int sizePage) {
        Pageable pageable = PageRequest.of(pageNo, sizePage);
        return passengerRepo.findAllPassenger(pageable);
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepo.findAllPassengers();
    }

    @Override
    public Passenger findPassengerById(Long passenger) {
        Passenger passenger1 = passengerRepo.findByIdPassenger(passenger);
        if(passenger1.getDelete() == Delete.INACTIVE)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found");
        return passenger1;
    }

    @Override
    public Passenger update(PassengerUpdateDto passengerUpdateDto, Delete delete) {
        Passenger passenger = PassengerMapper.INSTANCE.passengerUpdateDtoToPassenger(passengerUpdateDto);
        passengerRepo.findById(passenger.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Passenger not found"));
        passenger.setDelete(delete);

        return passengerRepo.save(passenger);
    }
}
