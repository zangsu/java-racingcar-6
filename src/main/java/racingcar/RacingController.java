package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.movenumber.MoveNumberGenerator;
import racingcar.domain.movenumber.NumberOfTrials;
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
        NumberOfTrials numberOfTrials = QuitHandler.getOrQuit(() -> getNumberOfTrials());
        moveCars(cars, numberOfTrials);
        getWinner(cars);
    }

    private void getWinner(Cars cars) {
        List<String> winners = cars.getWinners();
        OutputView.printWinner(winners);
    }

    private void moveCars(Cars cars, NumberOfTrials numberOfTrials) {
        OutputView.printResultHead();
        while (numberOfTrials.canTry()) {
            numberOfTrials.tryOnce();
            cars.moveAll(numberGenerator);
            OutputView.printRoundResult(cars);
        }
    }

    public Cars getCars() {
        List<String> carNames = InputView.getCarNames();
        return new Cars(carNames);
    }

    public NumberOfTrials getNumberOfTrials() {
        int numberOfTrials = InputView.getNumberOfTrials();
        return new NumberOfTrials(numberOfTrials);
    }

}
