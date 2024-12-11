package subway.view.input.exception;

public enum InputErrorMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"),
    INCORRECT_INPUT_FORMAT("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.\n"),
    NON_EXIST_STATION("존재하지 않는 역입니다."),
    DEPARTURE_ARRIVAL_ARE_SAME("출발역과 도착역이 동일합니다.\n"),
    NOT_CONNECTED("출발역과 도착역이 연결되지 않았습니다.\n");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    InputErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
