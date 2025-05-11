package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.models.Carriage;
import kg.mega.trainvoyage.repositories.CarriageRepo;
import kg.mega.trainvoyage.services.CarriageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CarriageServiceImpl implements CarriageService {
    private final CarriageRepo carriageRepo;

    public CarriageServiceImpl(CarriageRepo carriageRepo) {
        this.carriageRepo = carriageRepo;
    }

    @Override
    public Carriage findById(Long id) {

        return carriageRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carriage not found"));
    }
}
