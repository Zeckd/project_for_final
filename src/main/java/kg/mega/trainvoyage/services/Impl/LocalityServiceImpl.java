package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.models.Locality;
import kg.mega.trainvoyage.repositories.LocalityRepo;
import kg.mega.trainvoyage.services.LocalityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LocalityServiceImpl implements LocalityService {
    private final LocalityRepo localityRepo;

    public LocalityServiceImpl(LocalityRepo localityRepo) {
        this.localityRepo = localityRepo;
    }

    @Override
    public Locality findById(Long id) {

        return localityRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locality not found"));
    }
}
