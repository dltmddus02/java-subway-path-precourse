package subway.view.input;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.input.exception.InputErrorMessage;
import subway.view.input.exception.InputException;

public class InputValidator {
    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateMainFeature(String input) {
        if (!input.equals("1") && !input.equals("Q")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validatePathCriteriaFeature(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("B")) {
            throw new InputException(InputErrorMessage.INVALID_INPUT);
        }
    }

    public static void validateExistingStation(String input) {
        for (Station station : StationRepository.stations()) {
            if (station.getName().equals(input)) {
                return;
            }
        }
        throw new InputException(InputErrorMessage.NON_EXIST_STATION);
    }

    public static void validateStationFormat(String departure, String arrival) {
        if (departure.equals(arrival)) {
            throw new InputException(InputErrorMessage.DEPARTURE_ARRIVAL_ARE_SAME);
        }
    }
}
