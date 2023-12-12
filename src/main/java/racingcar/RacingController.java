package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.exception.handler.QuitHandler;
import racingcar.view.InputView;

public class RacingController {

    public void run(){
        Cars cars = QuitHandler.getOrQuit(() -> getCars());
    }

    public Cars getCars() {
        List<String> carNames = InputView.getCarNames();
        return new Cars(carNames);
    }

}
