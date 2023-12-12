package racingcar.domain.movenumber;

public interface MoveNumberGenerator {
    int MIN_NUMBER = 0;
    int MAX_NUMBER = 9;

    int generate();
}
