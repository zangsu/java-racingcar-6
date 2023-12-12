package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.movenumber.MoveNumberGenerator;
import racingcar.exception.handler.QuitHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final MoveNumberGenerator numberGenerator;

    public RacingController(MoveNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }


    public void run() {
        Cars cars = QuitHandler.getOrQuit(() -> getCars());
        int numberOfTrials = QuitHandler.getOrQuit(() -> getNumberOfTrials());
        moveCars(cars, numberOfTrials);

    }

    private void moveCars(Cars cars, int numberOfTrials) {
        for (int i = 0; i < numberOfTrials; i++) {
            cars.moveAll(numberGenerator);
            OutputView.printRoundResult(cars);
        }
    }

    public Cars getCars() {
        List<String> carNames = InputView.getCarNames();
        return new Cars(carNames);
    }

    public int getNumberOfTrials() {
        return InputView.getNumberOfTrials();
    }

}
