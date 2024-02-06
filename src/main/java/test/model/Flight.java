package test.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String origin;
        @JsonProperty("origin_name")
        private String originName;

        private String destination;
        @JsonProperty("destination_name")
        private String destinationName;

        @JsonProperty("departure_date")
        private String departureDate;
        @JsonProperty("departure_time")
        private String departureTime;
        @JsonProperty("arrival_date")
        private String arrivalDate;
        @JsonProperty("arrival_time")
        private String arrivalTime;

        private String carrier;

        private int stops;

        private int price;
}

