package kg.mega.trainvoyage.services;

import jakarta.validation.Valid;
import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;
import kg.mega.trainvoyage.models.dto.VoyageUpdateDto;

import java.util.List;

public interface VoyageService {
    VoyageCreateDto create(VoyageCreateDto voyageCreateDto);

    Voyage findById(Long id);

    List<Voyage> findAllToList(int pageNo, int sizePage);

    List<Voyage> findAll();

    Voyage update(@Valid VoyageUpdateDto voyageUpdateDto, Delete delete);
}
