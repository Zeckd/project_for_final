package kg.mega.trainvoyage.controllers;

import jakarta.validation.Valid;
import kg.mega.trainvoyage.enums.Delete;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.dto.PassengerTicketTransactionDto;
import kg.mega.trainvoyage.models.dto.PassengerUpdateDto;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;
import kg.mega.trainvoyage.models.dto.TicketUpdateDto;
import kg.mega.trainvoyage.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody TicketCreateDto ticketCreateDto) {
        Ticket ticket = ticketService.create(ticketCreateDto);
        return ResponseEntity.ok(ticket);

    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Ticket> tickets = ticketService.findAll();
        if (tickets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tickets);
    }
    @GetMapping("/list")
    public List<Ticket> findAll(@RequestParam int pageNo, @RequestParam int sizePage) {

        return ticketService.findAllToList(pageNo, sizePage);
    }
    @GetMapping("/transactions")
    public ResponseEntity<?> getAllPassengerTransactionsById (@RequestParam Long passengerId, @RequestParam int pageNo, @RequestParam int pageSize) {

        PassengerTicketTransactionDto passengerTransactionDtos = ticketService.getAllPassengerTransactionsById (passengerId, pageNo,pageSize);

        return ResponseEntity.ok(passengerTransactionDtos);

    }
    @GetMapping("/{id}")
    public Ticket getById(@PathVariable("id") Long id) {
        return ticketService.findById(id);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody TicketUpdateDto ticketUpdateDto, @RequestParam Delete delete) {
        Ticket ticket = ticketService.update(ticketUpdateDto, delete);
        return ResponseEntity.ok(ticket);
    }
}
