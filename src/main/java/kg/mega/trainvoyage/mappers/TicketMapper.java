package kg.mega.trainvoyage.mappers;

import kg.mega.trainvoyage.models.Carriage;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.Voyage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passenger", source = "passenger")


    @Mapping(target = "carriage", source = "carriage")
    @Mapping(target = "price", expression = "java(voyage.getPrice() + carriage.getCarriageType().getExtraPrice())")

    Ticket toTicket(Passenger passenger,Carriage carriage, Voyage voyage);
}
