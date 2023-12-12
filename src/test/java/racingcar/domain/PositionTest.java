package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingExceptionMaker;

class PositionTest {

    @Nested
    @DisplayName("Position 생성 테스트")
    class 생성_테스트 {

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 10})
        @DisplayName("Position 생성 테스트")
        void 정상_생성_테스트(int position) {
            // when & then
            Assertions.assertThatNoException()
                    .isThrownBy(() -> new Position(position));
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -10})
        @DisplayName("Position 생성 실패 테스트: 음수")
        void Position_생성_실패_테스트_음수(int position) {
            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Position(position))
                    .withMessage(RacingExceptionMaker.INVALID_POSITION.getMessage());
        }
    }
}