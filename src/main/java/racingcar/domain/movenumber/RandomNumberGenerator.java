package racingcar.domain.movenumber;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements MoveNumberGenerator {
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
