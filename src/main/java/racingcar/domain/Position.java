package racingcar.domain;

import java.util.Objects;
import racingcar.exception.RacingExceptionMaker;

public class Position implements Comparable<Position> {
    private static final int MOVE_DISTANCE = 1;
    private int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw RacingExceptionMaker.INVALID_POSITION.makeException();
        }
    }

    public void move() {
        position += MOVE_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(position, o.position);
    }
}
