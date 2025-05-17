package kg.mega.trainvoyage.repositories;

import kg.mega.trainvoyage.models.Passenger;
import kg.mega.trainvoyage.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

    @Query("select u from Passenger u where u.delete = 0")
    List<Passenger> findAll();
}
