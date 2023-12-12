package racingcar.exception;

public enum RacingExceptionMaker {
    INVALID_NUMBER_FORMAT("숫자를 입력해 주세요"),
    INVALID_INPUT_FORMAT("입력 형식이 잘못되었습니다."),

    BLANK_INPUT("입력값이 비어 있습니다."),
    TOO_LONG_NAME("이름은 5자 이하로 입력해 주세요."),
    DUPLICATED_NAME("중복된 이름이 있습니다.");

    private final String message;
    private final IllegalArgumentException exception;

    RacingExceptionMaker(String message) {
        this.message = message;
        this.exception = new IllegalArgumentException(this.message);
    }

    public IllegalArgumentException makeException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }
}
