package subway.view.output;

import static subway.view.output.OutputMessage.INFO_PREFIX;
import static subway.view.output.OutputMessage.INFO_SEPARATOR;
import static subway.view.output.OutputMessage.INFO_TOTAL_DISTANCE;
import static subway.view.output.OutputMessage.INFO_TOTAL_TIME;
import static subway.view.output.OutputMessage.INPUT_ARRIVAL_STATION;
import static subway.view.output.OutputMessage.INPUT_DEPARTURE_STATION;
import static subway.view.output.OutputMessage.INPUT_FEATURE;
import static subway.view.output.OutputMessage.MAIN_SCREEN;
import static subway.view.output.OutputMessage.PATH_CRITERIA;

import java.util.List;

public class OutputView {
    public static void printMainScreen() {
        System.out.println(MAIN_SCREEN.getMessage());
    }

    public static void printPathCriteria() {
        System.out.println(PATH_CRITERIA.getMessage());
    }

    public static void printFeature() {
        System.out.println(INPUT_FEATURE.getMessage());
    }

    public static void printDepartureStation() {
        System.out.println(INPUT_DEPARTURE_STATION.getMessage());
    }

    public static void printArrivalStation() {
        System.out.println(INPUT_ARRIVAL_STATION.getMessage());
    }

    public static void printResult(Integer totalDistance, Integer totalTime, List<String> stations) {
        System.out.println(INFO_PREFIX.getMessage() + INFO_SEPARATOR.getMessage());
        System.out.printf(INFO_PREFIX.getMessage() + INFO_TOTAL_DISTANCE.getMessage(), totalDistance);
        System.out.printf(INFO_PREFIX.getMessage() + INFO_TOTAL_TIME.getMessage(), totalTime);
        System.out.println(INFO_PREFIX.getMessage() + INFO_SEPARATOR.getMessage());

        for (String station : stations) {
            System.out.println(INFO_PREFIX.getMessage() + station);
        }
    }
}
