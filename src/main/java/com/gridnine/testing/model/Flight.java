package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Bean that represents a flight.
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = List.copyOf(segs);
    }

    public List<Segment> getSegments() {
        return List.copyOf(segments);
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}