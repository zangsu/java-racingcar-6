package racingcar;

import java.util.Arrays;
import racingcar.constant.ExceptionMessage;

public class InputValidator {

    /**
     * validate car's name satisfy below - car name should be longer than 5 characters - car name should not empty or
     * blank - car's name should not be duplicated
     *
     * @param names car's names
     */
    public static void validateCarsName(String[] names) {
        validateEachName(names);
        validateDuplication(names);
    }

    private static void validateDuplication(String[] names) {
        int distinctNum = (int) Arrays.stream(names).distinct().count();

        if (distinctNum != names.length) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
    }

    private static void validateEachName(String[] names) {
        for (String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_TOO_LONG);
            }
        }
    }

    /**
     * validate roundNumberString satisfy below - roundNumberString should be number-format - roundNumber should be
     * positive number
     *
     * @param roundNumberString round number in String
     */
    public static void validateRoundNumber(String roundNumberString) {
        int roundNumber;
        try {
            roundNumber = Integer.parseInt(roundNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_BE_NUMBER);
        }

        if (roundNumber <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_NUMBER_MUST_POSITIVE);
        }
    }
}
