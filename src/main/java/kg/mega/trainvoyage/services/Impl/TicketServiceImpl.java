package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.mappers.TicketMapper;
import kg.mega.trainvoyage.models.Carriage;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;
import kg.mega.trainvoyage.repositories.TicketRepo;
import kg.mega.trainvoyage.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepo ticketRepo;
    private final PassengerService passengerService;
    private final CarriageService carriageService;

    private final VoyageService voyageService;
    private final TicketMapper ticketMapper = TicketMapper.INSTANCE;


    public TicketServiceImpl(TicketRepo ticketRepo, PassengerService passengerService, CarriageService carriageService, TrainService trainService, VoyageService voyageService) {
        this.ticketRepo = ticketRepo;
        this.passengerService = passengerService;
        this.carriageService = carriageService;

        this.voyageService = voyageService;
    }

    @Override
    public Ticket create(TicketCreateDto ticketCreateDto) {
        Voyage voyage = voyageService.findById(ticketCreateDto.voyage());
        Carriage carriage = carriageService.findById(ticketCreateDto.carriage());
        Passenger passenger = passengerService.findById(ticketCreateDto.passenger());
//        Ticket ticket = new Ticket();
//        ticket.setPassenger(passengerService.findById(ticketCreateDto.passenger()));
//        ticket.setVoyage(voyage);
//        ticket.setCarriage(carriage);
//        ticket.setPrice(voyage.getPrice() + carriage.getCarriageType().getExtraPrice());
//        ticket = ticketRepo.save(ticket);
        Ticket ticket = ticketMapper.toTicket(passenger, carriage, voyage);

        return ticketRepo.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
    }
}
