package kg.mega.trainvoyage.mappers;

import kg.mega.trainvoyage.models.Carriage;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.PassengerTicketTransactionDto;
import kg.mega.trainvoyage.models.dto.TicketTransactionDto;
import kg.mega.trainvoyage.models.dto.TicketUpdateDto;
import kg.mega.trainvoyage.models.dto.VoyageUpdateDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passenger", source = "passenger")
    @Mapping(target = "carriage", source = "carriage")
    @Mapping(target = "price", expression = "java(voyage.getPrice() + carriage.getCarriageType().getExtraPrice())")
    @Mapping(target = "delete", ignore = true)
    Ticket toTicket(Passenger passenger,Carriage carriage, Voyage voyage);

    @Mapping(source = "ticket.price", target = "totalAmount")
    PassengerTicketTransactionDto ticketToPassengerTicketDto(Ticket ticket);
    @InheritInverseConfiguration
    Ticket passengerTicketToTicket(PassengerTicketTransactionDto passengerTicketDto);

    List<TicketTransactionDto> ticketsToTicketTransactionDtos(List<Ticket> tickets);




    List<Ticket> TicketDtoListToTicketList(List<TicketTransactionDto> ticketDtoList);

    Ticket TicketDtoToTicket(TicketTransactionDto ticketDto);


    TicketTransactionDto ticketToTicketTransactionDto(Ticket ticket);

    List<PassengerTicketTransactionDto> ticketToPassengerTicketDto(List<Ticket> tickets);

}
