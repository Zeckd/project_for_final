package kg.mega.trainvoyage.repositories;

import kg.mega.trainvoyage.models.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageRepo extends JpaRepository<Carriage, Long> {
}
