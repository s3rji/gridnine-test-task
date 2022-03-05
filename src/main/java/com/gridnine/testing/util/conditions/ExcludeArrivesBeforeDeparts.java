package com.gridnine.testing.util.conditions;

import com.gridnine.testing.model.Flight;

import java.util.function.Predicate;

public class ExcludeArrivesBeforeDeparts implements Condition<Flight> {

    @Override
    public Predicate<Flight> getPredicate() {
        return flight -> flight.getSegments().stream()
                .allMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate()));
    }
}
