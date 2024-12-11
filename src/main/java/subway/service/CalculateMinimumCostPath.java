package subway.service;

import java.util.List;
import java.util.Map;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;

public class CalculateMinimumCostPath {
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

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        dijkstraShortestPath.getPath(departure, arrival).getWeight();

//                .getVertexList();
        return shortestPath;
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

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departure, arrival).getVertexList();

        return shortestPath;

    }
}
