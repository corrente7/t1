package test.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import test.model.Flight;
import test.parser.Parser;
import test.service.FlightService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    private final FlightService flightService;
    private final Parser parser;

    @Override
    public void run(String... args) throws Exception {

        List<Flight> flights = parser.getFlights();

        flightService.saveAll(flights);

        System.out.println("Min flight duration by carrier: " + flightService.getMinDurationByCarrier());
        System.out.println("Difference between the average price and median: " + flightService.getDiffBetweenAvAndM());
    }
}
