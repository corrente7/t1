package test.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import test.model.Flight;
import test.model.Tickets;

import java.io.File;
import java.util.List;

@Component
public class Parser {

    public List<Flight> getFlights() {

        List<Flight> flightsList = null;

        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            File file = new File("src/main/resources/tickets.json");

            Tickets flights = mapper.reader()
                    .forType(Tickets.class)
                    .readValue(file);
            flightsList = flights.getTickets();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flightsList;
    }


}
