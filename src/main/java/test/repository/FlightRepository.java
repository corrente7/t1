package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.model.Flight;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findById(long id);

    @Query(value = "SELECT * FROM flights f WHERE f.origin_name='Владивосток' AND f.destination_name='Тель-Авив'", nativeQuery = true)
    List<Flight> VVOtoTLV();

    @Query(value = "SELECT carrier FROM flights", nativeQuery = true)
    Set<String> getCarriers();

}
