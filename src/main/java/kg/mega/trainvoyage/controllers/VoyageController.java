package kg.mega.trainvoyage.controllers;

import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Voyage;
import kg.mega.trainvoyage.models.dto.VoyageCreateDto;
import kg.mega.trainvoyage.services.VoyageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/voyage")
public class VoyageController {
    private final VoyageService voyageService;

    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody VoyageCreateDto voyageCreateDto) {
        voyageCreateDto = voyageService.create(voyageCreateDto);


        return ResponseEntity.ok(voyageCreateDto) ;
    }
    //Чтобы самому не писать Json запрос
    @GetMapping("/{id}")
    public Voyage findById(@PathVariable Long id) {
        return voyageService.findById(id);
    }
    @GetMapping("/list")
    public List<Voyage> findAlltoList(@RequestParam int pageNo, @RequestParam int sizePage) {

        return voyageService.findAllToList(pageNo, sizePage);
    }
    @GetMapping("/all")
    public List<Voyage> findAll() {

        return voyageService.findAll();
    }
}
