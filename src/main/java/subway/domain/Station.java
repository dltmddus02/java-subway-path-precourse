package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Station {
    private final String name;
    private Map<Station, Map<Station, List<Integer>>> adjacentStations;

    public Station(String name) {
        this.name = name;
        this.adjacentStations = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Station, Map<Station, List<Integer>>> getAdjacentStations(Station station) {
        return adjacentStations;
    }

    public void setAdjacentStations(Map<Station, Map<Station, List<Integer>>> adjacentStations) {
        this.adjacentStations = adjacentStations;
    }
}
