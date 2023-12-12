package racingcar.domain;

import racingcar.exception.RacingExceptionMaker;

public class CarName {
    public static final int MAX_NAME_LEN = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name == null || name.isBlank()) {
            throw RacingExceptionMaker.BLANK_INPUT.makeException();
        }
        if(name.length() > MAX_NAME_LEN) {
            throw RacingExceptionMaker.TOO_LONG_NAME.makeException();
        }
    }

    public String getName() {
        return name;
    }
}
