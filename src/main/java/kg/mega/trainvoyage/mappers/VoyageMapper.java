package kg.mega.trainvoyage.mappers;

import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VoyageMapper {
    VoyageMapper INSTANCE = Mappers.getMapper(VoyageMapper.class);
    List<VoyageCreateDto> voyageToVoyageCreateDto(List<Voyage> voyage);
    List<Voyage> voyageCreateDtoToVoyage(List<VoyageCreateDto> voyageCreateDto);
}
