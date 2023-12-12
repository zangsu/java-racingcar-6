package racingcar.view;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.view.io.Printer;

public class OutputView {
    public static final String EXCEPTION_PREFIX = "[ERROR] ";

    public static void printException(Exception e) {
        Printer.printMessage(EXCEPTION_PREFIX + e.getMessage());
    }

    public static void newLine() {
        Printer.printMessage("");
    }

    private static <T> void printListUsingFormat(List<T> list) {
        list.forEach(t -> Printer.printMessageUsingFormat("FORMAT", 1, 2, 3));
    }

    public static void printResultHead() {
        Printer.printMessage("실행 결과");
    }

    public static void printRoundResult(Cars cars) {
        cars.getCars()
                .forEach(car -> Printer.printMessageUsingFormat("%s : %s",
                        car.getName(),
                        "-".repeat(car.getPosition())));
        newLine();
    }

    public static void printWinner(List<String> winners) {
        Printer.printMessage("최종 우승자 : " + String.join(", ", winners));
    }
}
