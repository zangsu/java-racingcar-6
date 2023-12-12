package racingcar.domain;

import java.util.List;
import racingcar.exception.RacingExceptionMaker;

public class Cars {
    private final List<Car> cars;


    public Cars(List<String> carNames) {
        validateCarNames(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw RacingExceptionMaker.BLANK_INPUT.makeException();
        }
        int duplicatedCount = (int) carNames.stream()
            .distinct()
            .count();
        if (duplicatedCount != carNames.size()) {
            throw RacingExceptionMaker.DUPLICATED_NAME.makeException();
        }
    }
}
