package kg.mega.trainvoyage.controllers;

import jakarta.validation.Valid;
import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.dto.TicketCreateDto;
import kg.mega.trainvoyage.services.TicketService;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/{id}")
    public Ticket getById(@PathVariable("id") Long id) {
        return ticketService.findById(id);
    }
}
