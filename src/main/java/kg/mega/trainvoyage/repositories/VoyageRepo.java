package kg.mega.trainvoyage.repositories;

import kg.mega.trainvoyage.models.Ticket;
import kg.mega.trainvoyage.models.Voyage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoyageRepo extends JpaRepository<Voyage, Long> {

    @Query("select u from Voyage u ")
    List<Voyage> findAllVoyage(Pageable pageable);

    @Query("select u from Voyage u where u.delete = 0")
    List<Voyage> findAll();
}
