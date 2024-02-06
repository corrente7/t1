package test.utils;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class FlightDuration {

    public Duration getDuration(String departureTime, String arrivalTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime formattedArrival = LocalTime.parse(arrivalTime, formatter);
        LocalTime formattedDeparture = LocalTime.parse(departureTime, formatter);

        return Duration.between(formattedDeparture, formattedArrival);
    }
}
