package com.gridnine.testing;


import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.FlightBuilder;
import com.gridnine.testing.util.FlightUtil;
import com.gridnine.testing.util.conditions.ExcludeArrivesBeforeDeparts;
import com.gridnine.testing.util.conditions.ExcludeDepartsBeforeNow;
import com.gridnine.testing.util.conditions.ExcludeLandingTimeMoreTwoHours;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        FlightUtil.filterByCondition(flightList, new ExcludeDepartsBeforeNow()).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");
        FlightUtil.filterByCondition(flightList, new ExcludeArrivesBeforeDeparts()).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");
        FlightUtil.filterByCondition(flightList, new ExcludeLandingTimeMoreTwoHours()).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");
    }
}
