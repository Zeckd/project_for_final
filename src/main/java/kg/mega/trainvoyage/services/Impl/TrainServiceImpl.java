package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.models.Train;
import kg.mega.trainvoyage.repositories.TrainRepo;
import kg.mega.trainvoyage.services.TrainService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TrainServiceImpl implements TrainService {
    private final TrainRepo trainRepo;

    public TrainServiceImpl(TrainRepo trainRepo) {
        this.trainRepo = trainRepo;
    }

    @Override
    public Train findById(Long id) {
        return trainRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Train not found"));
    }
}
