package com.gridnine.testing.util;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.util.conditions.ExcludeArrivesBeforeDeparts;
import com.gridnine.testing.util.conditions.ExcludeDepartsBeforeNow;
import com.gridnine.testing.util.conditions.ExcludeLandingTimeMoreTwoHours;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FlightUtilTest {
    @Test
    void excludeDepartsBeforeNowTest() {
        List<Flight> flightList = new ArrayList<>(FlightBuilder.createFlights());
        List<Flight> filteredList = FlightUtil.filterByCondition(flightList, new ExcludeDepartsBeforeNow());
        assertThat(flightList.size()).isEqualTo(6);
        assertThat(filteredList.size()).isEqualTo(5);
        flightList.remove(2);
        assertThat(filteredList).usingRecursiveFieldByFieldElementComparator().isEqualTo(flightList);
    }

    @Test
    void excludeArrivesBeforeDepartsTest() {
        List<Flight> flightList = new ArrayList<>(FlightBuilder.createFlights());
        List<Flight> filteredList = FlightUtil.filterByCondition(flightList, new ExcludeArrivesBeforeDeparts());
        assertThat(flightList.size()).isEqualTo(6);
        assertThat(filteredList.size()).isEqualTo(5);
        flightList.remove(3);
        assertThat(filteredList).usingRecursiveFieldByFieldElementComparator().isEqualTo(flightList);
    }

    @Test
    void excludeLandingTimeMoreTwoHoursTest() {
        List<Flight> flightList = new ArrayList<>(FlightBuilder.createFlights());
        List<Flight> filteredList = FlightUtil.filterByCondition(flightList, new ExcludeLandingTimeMoreTwoHours());
        assertThat(flightList.size()).isEqualTo(6);
        assertThat(filteredList.size()).isEqualTo(4);
        flightList.remove(5);
        flightList.remove(4);
        assertThat(filteredList).usingRecursiveFieldByFieldElementComparator().isEqualTo(flightList);
    }
}