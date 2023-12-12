package racingcar.domain.movenumber;

import java.util.LinkedList;
import java.util.List;

public class ListValueGenerator implements MoveNumberGenerator {
    private final List<Integer> values;

    public ListValueGenerator(List<Integer> values) {
        boolean hasOutRangeNumber = values.stream().anyMatch(value -> value < MIN_NUMBER || value > MAX_NUMBER);
        if (hasOutRangeNumber) {
            throw new IllegalArgumentException("0~9 사이의 숫자만 입력 가능합니다.");
        }
        this.values = new LinkedList<>(values);
    }

    @Override
    public int generate() {
        if (values.size() == 1) {
            return values.get(0);
        }
        return values.remove(0);
    }
}
