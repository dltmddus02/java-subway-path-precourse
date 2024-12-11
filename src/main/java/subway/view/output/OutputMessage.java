package subway.view.output;

public enum OutputMessage {
    MAIN_SCREEN("## 메인 화면\n"
            + "1. 경로 조회\n"
            + "Q. 종료\n"),
    INPUT_FEATURE("## 원하는 기능을 선택하세요."),
    PATH_CRITERIA("## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n"),
    INPUT_PATH_CRITERIA("## 원하는 기능을 선택하세요."),
    INPUT_DEPARTURE_STATION("## 출발역을 입력하세요."),
    INPUT_ARRIVAL_STATION("## 도착역을 입력하세요."),
    INFO_PREFIX("[INFO] "),
    INFO_SEPARATOR("---"),
    INFO_TOTAL_DISTANCE("총 거리: %dkm\n"),
    INFO_TOTAL_TIME("총 소요 시간: %d분\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
