package kg.mega.trainvoyage.repositories;

import kg.mega.trainvoyage.models.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    @Query("select u  from Ticket u where u.id = ?1")
    Ticket findTicketTransactionDto(Long ticket);
    @Query("select u from Ticket u where u.passenger.id in ?1  " )
    List<Ticket> findAllTransactionsById(Long passengerId, Pageable pageable);
    @Query("select sum(t.price) from Ticket t where t.passenger.id = ?1")
    Double findTotalAmountByPassengerId(Long passengerId);


    @Query("select u from Ticket u where u.delete = 0")
    List<Ticket> findAll();
}
