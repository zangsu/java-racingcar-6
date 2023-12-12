package racingcar.domain;

public class Car {
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }
}
