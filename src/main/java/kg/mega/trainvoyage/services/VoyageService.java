package kg.mega.trainvoyage.services;

import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;

import java.util.List;

public interface VoyageService {
    VoyageCreateDto create(VoyageCreateDto voyageCreateDto);

    List<Voyage> findAll(int pageNo, int sizePage   );
    Voyage findById(Long id);
}
