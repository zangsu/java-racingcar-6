package racingcar.exception.handler;

import java.util.function.Supplier;
import racingcar.view.OutputView;

/**
 * XXXException 을 전달받아 예상한 예외에 대해서만 재시도, 그 외의 예외는 throw
 */
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

    public static void runOrQuit(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            throw e;
        } finally {
            OutputView.newLine();
        }
    }
}
