package kg.mega.trainvoyage.services.Impl;

import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.mappers.TicketMapper;
import kg.mega.trainvoyage.models.Carriage;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.PassengerTicketTransactionDto;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;
import kg.mega.trainvoyage.models.dto.TicketTransactionDto;
import kg.mega.trainvoyage.models.dto.TicketUpdateDto;
import kg.mega.trainvoyage.repositories.TicketRepo;
import kg.mega.trainvoyage.services.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return ticketRepo.findAllTickets();
    }

    @Override
    public Ticket findById(Long id) {
        Ticket ticket = ticketRepo.findByIdTicket(id);
        if(ticket.getDelete() == Delete.INACTIVE)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        return ticket;
    }

    @Override
    public List<Ticket> findAllToList(int pageNo, int sizePage) {
        Pageable pageable = PageRequest.of(pageNo, sizePage);
        return ticketRepo.findAllTicket(pageable);
    }


    @Override
    public PassengerTicketTransactionDto getAllPassengerTransactionsById(Long passengerId, int pageNo, int pageSize) {


        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List <Ticket> tickets = ticketRepo.findAllTransactionsById(passengerId, pageable);
        Double totalAmount = ticketRepo.findTotalAmountByPassengerId(passengerId);
        Passenger passenger = passengerService.findById(passengerId);
        List<TicketTransactionDto> ticketDtos = TicketMapper.INSTANCE.ticketsToTicketTransactionDtos(tickets);

        return new PassengerTicketTransactionDto(passenger, ticketDtos, totalAmount);
    }

    @Override
    public Ticket update(TicketUpdateDto ticketUpdateDto, Delete delete) {
        Voyage voyage = voyageService.findById(ticketUpdateDto.voyage());
        Carriage carriage = carriageService.findById(ticketUpdateDto.carriage());
        Passenger passenger = passengerService.findById(ticketUpdateDto.passenger());
        Ticket ticket = TicketMapper.INSTANCE.toTicket(passenger, carriage, voyage);
        ticketRepo.findById(ticketUpdateDto.id()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
        ticket.setDelete(delete);
        return ticketRepo.save(ticket);


    }
}
