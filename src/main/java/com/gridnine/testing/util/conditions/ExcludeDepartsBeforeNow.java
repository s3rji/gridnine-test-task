package com.gridnine.testing.util.conditions;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class ExcludeDepartsBeforeNow implements Condition<Flight> {

    @Override
    public Predicate<Flight> getPredicate() {
        return flight -> flight.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now());
    }
}
