package kg.mega.trainvoyage.services;

import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;

import java.util.List;

public interface VoyageService {
    VoyageCreateDto create(VoyageCreateDto voyageCreateDto);

    Voyage findById(Long id);

    List<Voyage> findAllToList(int pageNo, int sizePage);

    List<Voyage> findAll();
}
