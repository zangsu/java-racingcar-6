package racingcar.exception.handler;

import java.util.function.Supplier;
import racingcar.view.OutputView;

public class QuitHandler {

    public static <T> T getOrQuit(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            throw e;
        } finally {
            OutputView.newLine();
        }
    }
}
