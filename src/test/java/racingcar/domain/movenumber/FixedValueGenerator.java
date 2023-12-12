package racingcar.domain.movenumber;

public class FixedValueGenerator implements MoveNumberGenerator {
    private final int fixedValue;

    public FixedValueGenerator(int fixedValue) {
        if (fixedValue < MIN_NUMBER || fixedValue > MAX_NUMBER) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}
