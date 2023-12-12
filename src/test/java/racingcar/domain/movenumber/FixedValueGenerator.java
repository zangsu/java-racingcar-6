package racingcar.domain.movenumber;

public class FixedValueGenerator implements MoveNumberGenerator {
    @Override
    public int generate() {
        return 4;
    }
}
