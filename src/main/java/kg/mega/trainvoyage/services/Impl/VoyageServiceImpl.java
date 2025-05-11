package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;
import kg.mega.trainvoyage.repositories.VoyageRepo;
import kg.mega.trainvoyage.services.LocalityService;
import kg.mega.trainvoyage.services.TrainService;
import kg.mega.trainvoyage.services.VoyageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VoyageServiceImpl implements VoyageService {
    private final VoyageRepo voyageRepo;
    private final LocalityService localityService;
    private final TrainService trainService;

    public VoyageServiceImpl(VoyageRepo voyageRepo, LocalityService localityService, TrainService trainService) {
        this.voyageRepo = voyageRepo;
        this.localityService = localityService;
        this.trainService = trainService;
    }

    @Override
    public VoyageCreateDto create(VoyageCreateDto voyageCreateDto) {

        Voyage voyage = new Voyage();
        voyage.setDestination(localityService.findById(voyageCreateDto.destinationPointId()));


        voyage.setStartingPoint(localityService.findById(voyageCreateDto.startingPointId()));
        voyage.setDistance(voyageCreateDto.distance());
        voyage.setPrice(voyageCreateDto.price());
        voyage.setSendDate(voyageCreateDto.sendDate());
        voyage.setSendTime(voyageCreateDto.sendTime());
        voyage.setArrivalTime(voyageCreateDto.arrivalDateTime());
        voyage.setTrain(trainService.findById(voyageCreateDto.trainId()));
        voyage = voyageRepo.save(voyage);
        voyage.setId(voyage.getId());

        return voyageCreateDto;
    }

    @Override
    public List<Voyage> findAllToList(int pageNo, int sizePage) {
        Pageable pageable = PageRequest.of(pageNo, sizePage, Sort.by(Sort.Direction.DESC, "id"));
        return voyageRepo.findAll(pageable).toList();
    }

    @Override
    public List<Voyage> findAll() {
        return voyageRepo.findAll();
    }

    @Override
    public Voyage findById(Long id) {

        return voyageRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Voyage not found"));
    }

}
