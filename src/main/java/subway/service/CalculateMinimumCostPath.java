package subway.service;

import java.util.List;
import java.util.Map;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;

public class CalculateMinimumCostPath {
    private static Integer totalDistance = 0;
    private static Integer totalTime = 0;

    WeightedMultigraph<String, DefaultWeightedEdge> graph
            = new WeightedMultigraph(DefaultWeightedEdge.class);

    public List<String> shortestDistance(String departure, String arrival) {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        for (Station station : StationRepository.stations()) {
            for (Map.Entry<Station, Map<Station, List<Integer>>> entrySet : station.getAdjacentStations(station)
                    .entrySet()) {
                Station adjacentStation = entrySet.getKey();
                Map<Station, List<Integer>> adjList = entrySet.getValue();

                for (List<Integer> adjacentMap : adjList.values()) {
                    int distance = adjacentMap.get(0);
                    graph.setEdgeWeight(graph.addEdge(station.getName(), adjacentStation.getName()), distance);
                }
            }
        }
        return new DijkstraShortestPath<>(graph).getPath(departure,arrival).getVertexList();
    }

    public List<String> minimumTime(String departure, String arrival) {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }
        for (Station station : StationRepository.stations()) {
            for (Map.Entry<Station, Map<Station, List<Integer>>> entrySet : station.getAdjacentStations(station)
                    .entrySet()) {
                Station adjacentStation = entrySet.getKey();
                Map<Station, List<Integer>> adjList = entrySet.getValue();

                for (List<Integer> adjacentMap : adjList.values()) {
                    int time = adjacentMap.get(1);
                    graph.setEdgeWeight(graph.addEdge(station.getName(), adjacentStation.getName()), time);
                }
            }
        }
        return new DijkstraShortestPath<>(graph).getPath(departure,arrival).getVertexList();
    }
}
