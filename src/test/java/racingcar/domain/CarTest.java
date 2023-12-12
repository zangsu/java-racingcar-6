package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.RacingExceptionMaker;

class CarTest {

    @Nested
    @DisplayName("자동차 생성 테스트")
    class 생성_테스트 {

        @Test
        @DisplayName("자동차 생성 테스트")
        void 정상_생성_테스트() {
            // given
            String name = "pobi";

            // when & then
            Assertions.assertThatNoException()
                    .isThrownBy(() -> new Car(name));
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: null")
        void 자동차_생성_실패_테스트_null() {
            // given
            String name = null;

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(name))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 빈 문자열")
        void 자동차_생성_실패_테스트_빈_문자열() {
            // given
            String name = "";

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(name))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 공백 문자열")
        void 자동차_생성_실패_테스트_공백_문자열() {
            // given
            String name = " ";

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(name))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 5자 초과")
        void 자동차_생성_실패_테스트_5자_초과() {
            // given
            String name = "abcdef";

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Car(name))
                    .withMessage(RacingExceptionMaker.TOO_LONG_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 후 초기 값 테스트")
        void 자동차_생성_후_초기_값_테스트() {
            // given
            String name = "pobi";

            // when
            Car car = new Car(name);

            // then
            assertEquals(name, car.getName());
            assertEquals(0, car.getPosition());
        }
    }

    @Nested
    @DisplayName("자동차 이동 테스트")
    class 자동차_이동_테스트 {

        private Car car;

        @BeforeEach
        void setUp() {
            car = new Car("pobi");
        }

        @ParameterizedTest(name = "{0}의 값이 주어지면 자동차가 전진한다.")
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @DisplayName("자동차 전진 테스트")
        void 자동차_전진_테스트(int moveNumber) {
            car.move(moveNumber);

            Assertions.assertThat(car.getPosition())
                    .isEqualTo(1);
        }

        @ParameterizedTest(name = "{0}의 값이 주어지면 자동차가 정지한다.")
        @ValueSource(ints = {0, 1, 2, 3})
        @DisplayName("자동차 정지 테스트")
        void 자동차_정지_테스트(int moveNumber) {
            car.move(moveNumber);

            Assertions.assertThat(car.getPosition())
                    .isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("자동차 위치 비교 테스트")
    class 자동차_위치_비교_테스트 {
        public static final int MOVE = 4;
        private final Car car1 = new Car("pobi");
        private final Car car2 = new Car("crong");
        private final Car car3 = new Car("honux");

        @BeforeEach
        void setUp() {
            car3.move(MOVE);
            car3.move(MOVE);
        }

        @Test
        @DisplayName("자동차 위치 비교 테스트: car1 == car2 < car3")
        void 자동차_비교_테스트() {
            // when & then
            Assertions.assertThat(car1.compareTo(car2))
                    .isEqualTo(0);
            Assertions.assertThat(car1.compareTo(car3))
                    .isEqualTo(-1);

            Assertions.assertThat(car2.compareTo(car1))
                    .isEqualTo(0);
            Assertions.assertThat(car2.compareTo(car3))
                    .isEqualTo(-1);

            Assertions.assertThat(car3.compareTo(car1))
                    .isEqualTo(1);
            Assertions.assertThat(car3.compareTo(car2))
                    .isEqualTo(1);
        }
    }

}