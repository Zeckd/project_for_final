package kg.mega.trainvoyage.mappers;

import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.PassengerUpdateDto;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;
import kg.mega.trainvoyage.models.dto.VoyageUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassengerMapper {
//    @Mapping(source = "address", target = "address")
    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);
    PassengerUpdateDto passengerToPassengerUpdateDto(Passenger  passenger);
    Passenger passengerUpdateDtoToPassenger (PassengerUpdateDto passengerCreateDto);
//    PassengerMapper ticketByDtoToPassenger(TicketCreateDto ticketCreateDto);
}
