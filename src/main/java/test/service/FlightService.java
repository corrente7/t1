package test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.utils.FlightDuration;
import test.model.Flight;
import test.repository.FlightRepository;
import test.utils.MedianAndAverage;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private final FlightDuration formatter;

    private final MedianAndAverage medianAndAverage;

    public void saveAll(List<Flight> fruits){
        flightRepository.saveAll(fruits);
    }


    public List<Flight> getAll(){
        return flightRepository.findAll();
    }

    public List<Flight> getVVOtoTLV(){
        return flightRepository.VVOtoTLV();
    }

    public Set<String> getCarriers(){
        return flightRepository.getCarriers();
    }

    public List<Map<String, Object>> getMinDurationByCarrier(){
        List<Map<String, Object>> list = new ArrayList<>();
        List<Flight> flights = getVVOtoTLV();
        Set<String> carriers = getCarriers();
        List<Map<String, Object>> duration = new ArrayList<>();
        for (Flight flight : flights) {
            String departureTime = flight.getDepartureTime();
            String arrivalTime = flight.getArrivalTime();
            Map<String, Object> map = new HashMap<>();
            map.put("duration", formatter.getDuration(departureTime, arrivalTime));
            map.put("carrier", flight.getCarrier());
            duration.add(map);
        }
        for (String carrier : carriers) {
            List<Duration> d = new ArrayList<>();
            Duration minTime = null;
        for (Map<String, Object> map : duration) {
            if ((map.get("carrier")).equals(carrier)) {
                d.add(((Duration) map.get("duration")));
                minTime = Collections.min(d);
                map.replace("duration", minTime);
            }
        }
        }
        list = duration.stream().distinct().collect(Collectors.toList());
        return list;
    }

    public double getDiffBetweenAvAndM(){
        List<Integer> prices = new ArrayList<>();
        List<Flight> flights = getVVOtoTLV();
        for (Flight flight : flights) {
            int price = flight.getPrice();
            prices.add(price);
        }
        double average = medianAndAverage.findAverage(prices);
        double median = medianAndAverage.findMedian(prices);

        return average - median;
    }

    public Flight getFlight(long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Flight not found"));
    }
}
