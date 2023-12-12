package racingcar.view;

import java.util.List;
import racingcar.view.io.Printer;
import racingcar.view.io.Reader;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<String> getCarNames() {
        Printer.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Reader.getStringsUsingDelimiter(DELIMITER);
    }

    public static int getNumberOfTrials() {
        Printer.printMessage("시도할 회수는 몇회인가요?");
        return Reader.getInteger();
    }

}
