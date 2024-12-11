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
}
