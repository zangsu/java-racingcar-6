package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingExceptionMaker;

class CarNameTest {

    @Test
    @DisplayName("자동차 이름 생성 테스트")
    void 자동차_이름_생성_테스트() {
        // given
        String name = "pobi";

        // when & then
        Assertions.assertThatNoException()
                .isThrownBy(() -> new CarName(name));
    }

    @Test
    @DisplayName("자동차 이름 생성 실패 테스트: null")
    void 자동차_이름_생성_실패_테스트_null() {
        // given
        String name = null;

        // when & then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 생성 실패 테스트: 빈 문자열")
    void 자동차_이름_생성_실패_테스트_빈_문자열() {
        // given
        String name = "";

        // when & then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 생성 실패 테스트: 공백 문자열")
    void 자동차_이름_생성_실패_테스트_공백_문자열() {
        // given
        String name = " ";

        // when & then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 생성 실패 테스트: 5자 초과")
    void 자동차_이름_생성_실패_테스트_5자_초과() {
        // given
        String name = "abcdef";

        // when & then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(name))
                .withMessage(RacingExceptionMaker.TOO_LONG_NAME.getMessage());
    }
}