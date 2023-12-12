package racingcar.view.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.RacingExceptionMaker;

public class Reader {
    public static int getInteger() {
        String input = Console.readLine();
        return parseInt(input);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw RacingExceptionMaker.INVALID_NUMBER_FORMAT.makeException();
        }
    }

    public static String getString() {
        return Console.readLine();
    }

    public static List<String> getStringsUsingDelimiter(String delimiter) {
        String input = Console.readLine();
        validateNotEndDelimiter(input, delimiter);
        List<String> inputs = Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
        inputs.forEach(Reader::validateNotBlank);
        return inputs;
    }

    private static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw RacingExceptionMaker.BLANK_INPUT.makeException();
        }
    }

    private static void validateNotEndDelimiter(String input, String delimiter) {
        if (input.endsWith(delimiter)) {
            throw RacingExceptionMaker.INVALID_INPUT_FORMAT.makeException();
        }
    }
}
