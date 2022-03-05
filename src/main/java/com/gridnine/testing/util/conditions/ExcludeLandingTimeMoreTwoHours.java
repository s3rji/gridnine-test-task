package com.gridnine.testing.util.conditions;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;

public class ExcludeLandingTimeMoreTwoHours implements Condition<Flight> {

    @Override
    public Predicate<Flight> getPredicate() {
        return flight -> {
            LocalDateTime flightStart = flight.getSegments().get(0).getDepartureDate();
            LocalDateTime flightEnd = flight.getSegments().get(flight.getSegments().size() - 1).getArrivalDate();
            Long flightTotalHours = ChronoUnit.HOURS.between(flightStart, flightEnd);
            Long totalHoursInAir = flight.getSegments().stream()
                    .mapToLong(value -> ChronoUnit.HOURS.between(value.getDepartureDate(), value.getArrivalDate()))
                    .sum();
            return flightTotalHours - totalHoursInAir < 2;
        };
    }
}
