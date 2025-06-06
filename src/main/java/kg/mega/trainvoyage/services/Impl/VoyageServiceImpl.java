package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.mappers.VoyageMapper;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;
import kg.mega.trainvoyage.models.dto.VoyageUpdateDto;
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
        return voyageRepo.findAllVoyage(pageable);
    }

    @Override
    public List<Voyage> findAll() {
        return voyageRepo.findAllVoyages();
    }

    @Override
    public Voyage update(VoyageUpdateDto voyageUpdateDto, Delete delete) {
        Voyage voyage = VoyageMapper.INSTANCE.voyageUpdateDtoToVoyage(voyageUpdateDto);
        voyageRepo.findById(voyageUpdateDto.id()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Voyage not found"));
        voyage.setDelete(delete);
        return voyageRepo.save(voyage);
    }

    @Override
    public Voyage findById(Long id) {
        Voyage voyage = voyageRepo.findByIdVoyage(id);
        if(voyage.getDelete() == Delete.INACTIVE)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Voyage not found");
        return voyage;
    }

}
