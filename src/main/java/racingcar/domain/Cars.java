package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.movenumber.MoveNumberGenerator;
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

    public void moveAll(MoveNumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Comparator.naturalOrder())
                .get()
                .getPosition();
    }
}
