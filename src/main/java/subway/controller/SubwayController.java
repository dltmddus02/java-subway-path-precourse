package subway.controller;

import java.util.Scanner;
import java.util.function.Supplier;
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
//        setupSubwayStation();

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

}
