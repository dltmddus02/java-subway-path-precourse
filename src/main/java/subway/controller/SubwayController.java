package subway.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.CalculateMinimumCostPath;
import subway.view.input.InputValidator;
import subway.view.input.exception.InputException;
import subway.view.output.OutputView;

public class SubwayController {
    private static Integer totalDistance = 0;
    private static Integer totalTime = 0;
    private CalculateMinimumCostPath calculateMinimumCostPath = new CalculateMinimumCostPath();

    public SubwayController() {
        calculateMinimumCostPath = new CalculateMinimumCostPath();
    }

    public void run(Scanner scanner) {
        setupSubwayStation();

        OutputView.printMainScreen();
        String mainFeature = chooseMainFeature(scanner);
        if (mainFeature.equals("Q")) {
            return;
        }
        String pathCriteriaFeature = choosePathCriteriaFeature(scanner);
        if (pathCriteriaFeature.equals("B")) {
            run(scanner);
            return;
        }
        String departure = chooseDeparture(scanner);
        String arrival = chooseArrival(scanner);
        InputValidator.validateStationFormat(departure, arrival);

    }


    private String chooseMainFeature(Scanner scanner) {
        return retryOnInvalidInput(() -> {
            OutputView.printFeature();
            String feature = scanner.nextLine();
            InputValidator.validateMainFeature(feature);
            return feature;
        });
    }

    private String choosePathCriteriaFeature(Scanner scanner) {
        return retryOnInvalidInput(() -> {
            OutputView.printPathCriteria();
            OutputView.printFeature();
            String feature = scanner.nextLine();
            InputValidator.validatePathCriteriaFeature(feature);
            return feature;
        });
    }

    private String chooseDeparture(Scanner scanner) {
        return retryOnInvalidInput(() -> {
            OutputView.printDepartureStation();
            String feature = scanner.nextLine();
            InputValidator.validateExistingStation(feature);
            return feature;
        });
    }

    private String chooseArrival(Scanner scanner) {
        return retryOnInvalidInput(() -> {
            OutputView.printArrivalStation();
            String feature = scanner.nextLine();
            InputValidator.validateExistingStation(feature);
            return feature;
        });
    }


    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (InputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setupSubwayStation() {
        Station 교대역 = new Station("교대역");
        Station 강남역 = new Station("강남역");
        Station 역삼역 = new Station("역삼역");
        Station 남부터미널역 = new Station("남부터미널역");
        Station 양재역 = new Station("양재역");
        Station 매봉역 = new Station("매봉역");
        Station 양재시민의숲역 = new Station("양재시민의숲역");

        StationRepository.addStation(교대역);
        StationRepository.addStation(강남역);
        StationRepository.addStation(역삼역);
        StationRepository.addStation(남부터미널역);
        StationRepository.addStation(양재역);
        StationRepository.addStation(매봉역);
        StationRepository.addStation(양재시민의숲역);

        Map<Station, Map<Station, List<Integer>>> adjacent교대역 = new HashMap<>();
        List<Map<Integer, Integer>> 교대역인접정보 = new ArrayList<>();
        adjacent교대역.put(강남역, Map.of(교대역, List.of(2, 3)));
        adjacent교대역.put(남부터미널역, Map.of(교대역, List.of(3, 2)));
        교대역.setAdjacentStations(adjacent교대역);

        Map<Station, Map<Station, List<Integer>>> adjacent강남역 = new HashMap<>();
        adjacent강남역.put(역삼역, Map.of(강남역, List.of(2, 3)));
        adjacent강남역.put(양재역, Map.of(강남역, List.of(2, 8)));
        강남역.setAdjacentStations(adjacent강남역);

        Map<Station, Map<Station, List<Integer>>> adjacent역삼역 = new HashMap<>();
        List<Map<Integer, Integer>> 역삼역인접정보 = new ArrayList<>();
        역삼역.setAdjacentStations(adjacent역삼역);

        Map<Station, Map<Station, List<Integer>>> adjacent남부터미널역 = new HashMap<>();
        List<Map<Integer, Integer>> 남부터미널역인접정보 = new ArrayList<>();
        adjacent남부터미널역.put(양재역, Map.of(남부터미널역, List.of(6, 5)));
        남부터미널역.setAdjacentStations(adjacent남부터미널역);

        Map<Station, Map<Station, List<Integer>>> adjacent양재역 = new HashMap<>();
        List<Map<Integer, Integer>> 양재역인접정보 = new ArrayList<>();
        양재역인접정보.add(new HashMap<>(Map.of(1, 1)));  // 남부터미널역 (6호선, 1호선)
        양재역인접정보.add(new HashMap<>(Map.of(10, 3)));  // 남부터미널역 (6호선, 1호선)
        adjacent양재역.put(매봉역, Map.of(매봉역, List.of(1, 1)));
        adjacent양재역.put(양재시민의숲역, Map.of(매봉역, List.of(10, 3)));
        양재역.setAdjacentStations(adjacent양재역);

        Map<Station, Map<Station, List<Integer>>> adjacent매봉역 = new HashMap<>();
        매봉역.setAdjacentStations(adjacent매봉역);

        Map<Station, Map<Station, List<Integer>>> adjacent양재시민의숲역 = new HashMap<>();
        양재시민의숲역.setAdjacentStations(adjacent양재시민의숲역);

        Line line1 = new Line("2호선");
        Line line2 = new Line("3호선");
        Line line3 = new Line("신분당선");

        LineRepository.addLine(line1);
        LineRepository.addLine(line2);
        LineRepository.addLine(line3);
    }

}
