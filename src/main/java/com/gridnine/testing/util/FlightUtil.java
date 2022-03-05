package com.gridnine.testing.util;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.conditions.Condition;

import java.util.List;

public class FlightUtil {
    private FlightUtil() {
    }

    public static List<Flight> filterByCondition(List<Flight> flights, Condition<Flight> condition) {
        return flights.stream().filter(condition.getPredicate()).toList();
    }
}
