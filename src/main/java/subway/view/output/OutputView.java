package subway.view.output;

import static subway.view.output.OutputMessage.INPUT_ARRIVAL_STATION;
import static subway.view.output.OutputMessage.INPUT_DEPARTURE_STATION;
import static subway.view.output.OutputMessage.INPUT_FEATURE;
import static subway.view.output.OutputMessage.MAIN_SCREEN;
import static subway.view.output.OutputMessage.PATH_CRITERIA;

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
}
