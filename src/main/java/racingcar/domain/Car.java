package racingcar.domain;

public class Car {
    public static final int MIN_MOVE_NUMBER = 4;
    public static final int MOVE_DISTANCE = 1;
    public static final int INIT_POSITION = 0;
    private final CarName name;
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
}
