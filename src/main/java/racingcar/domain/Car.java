package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int INIT_POSITION = 0;
    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new Position(INIT_POSITION);
    }

    public void move(int moveNumber) {
        if (moveNumber >= MIN_MOVE_NUMBER) {
            position.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }

    public boolean isPositionAt(Position maxPosition) {
        return position.equals(maxPosition);
    }
}
