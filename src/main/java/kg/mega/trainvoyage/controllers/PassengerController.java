package kg.mega.trainvoyage.controllers;

import jakarta.validation.Valid;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.PassengerDto;
import kg.mega.trainvoyage.services.PassengerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createPassenger(@Valid @RequestBody Passenger passenger) {
        passenger = passengerService.create(passenger);

        return ResponseEntity.ok(passenger);


    }
    @GetMapping("/list")
    public List<Passenger> findAllToList(@RequestParam int pageNo, @RequestParam int sizePage) {

        return passengerService.findAllToList(pageNo, sizePage);
    }
    @GetMapping("/all")
    public List<Passenger> findAll() {

        return passengerService.findAll();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
         return passengerService.findById(id);
    }
}
