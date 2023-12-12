package racingcar.domain;

import racingcar.exception.RacingExceptionMaker;

public class NumberOfTrials {
    private int numberOfTrials;

    public NumberOfTrials(int numberOfTrials) {
        validate(numberOfTrials);
        this.numberOfTrials = numberOfTrials;
    }

    private void validate(int numberOfTrials) {
        if (numberOfTrials < 0) {
            throw RacingExceptionMaker.INVALID_NUMBER_OF_TRIALS.makeException();
        }
    }

    public boolean canTry() {
        return numberOfTrials > 0;
    }

    public void tryOnce() {
        if (!canTry()) {
            throw RacingExceptionMaker.NO_MORE_TRIALS.makeException();
        }
        numberOfTrials--;
    }
}
