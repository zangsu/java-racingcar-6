package racingcar;


import racingcar.domain.movenumber.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController(new RandomNumberGenerator());
        racingController.run();
    }
}
