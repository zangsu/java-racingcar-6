package racingcar.domain;

public class Car implements Comparable<Car> {
    public static final int MIN_MOVE_NUMBER = 4;
    public static final int MOVE_DISTANCE = 1;
    public static final int INIT_POSITION = 0;
    private final CarName name;
    //todo private final Position position;
    private int position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = INIT_POSITION;
    }

    public void move(int moveNumber) {
        if (moveNumber >= MIN_MOVE_NUMBER) {
            position += MOVE_DISTANCE;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(position, o.position);
    }

}
