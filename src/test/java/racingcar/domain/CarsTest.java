package racingcar.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.movenumber.FixedValueGenerator;
import racingcar.domain.movenumber.ListValueGenerator;
import racingcar.exception.RacingExceptionMaker;

class CarsTest {

    @Nested
    @DisplayName("자동차 생성 테스트")
    class 자동차_생성_테스트 {

        @Test
        @DisplayName("자동차 생성 테스트")
        void 정상_생성_테스트() {
            List<String> names = List.of("pobi", "crong", "honux");
            Assertions.assertThatNoException()
                    .isThrownBy(() -> new Cars(names));
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: null")
        void 자동차_생성_실패_테스트_null() {
            // given
            List<String> names = null;

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 빈_리스트")
        void 자동차_생성_실패_테스트_빈_리스트() {
            // given
            List<String> names = List.of();

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 중복된 이름")
        void 자동차_생성_실패_테스트_중복된_이름() {
            // given
            List<String> names = List.of("pobi", "pobi", "honux");

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names))
                    .withMessage(RacingExceptionMaker.DUPLICATED_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 5자 초과")
        void 자동차_생성_실패_테스트_5자_초과() {
            // given
            List<String> names = List.of("pobi", "crong", "honux", "jk", "abcdef");

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names))
                    .withMessage(RacingExceptionMaker.TOO_LONG_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 공백 문자열")
        void 자동차_생성_실패_테스트_공백_문자열() {
            // given
            List<String> names = List.of("pobi", "crong", "honux", " ");

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }

        @Test
        @DisplayName("자동차 생성 실패 테스트: 빈 문자열")
        void 자동차_생성_실패_테스트_빈_문자열() {
            // given
            List<String> names = List.of("pobi", "crong", "honux", "");

            // when & then
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Cars(names))
                    .withMessage(RacingExceptionMaker.BLANK_INPUT.getMessage());
        }
    }

    @Nested
    @DisplayName("자동차 우승자 테스트")
    class 자동차_우승자_테스트 {
        @Test
        @DisplayName("자동차 공동 우승 테스트")
        void 자동차_공동_우승_테스트() {
            // given
            List<String> names = List.of("pobi", "crong", "honux");
            Cars cars = new Cars(names);

            // when
            cars.moveAll(new FixedValueGenerator());

            // then
            Assertions.assertThat(cars.getWinners())
                    .containsExactly(names.toArray(String[]::new));
        }
        
        @Test
        @DisplayName("자동차 단독 우승 테스트")
        void 자동차_단독_우승_테스트() {
            // given
            List<String> names = List.of("pobi", "crong", "honux");
            Cars cars = new Cars(names);

            // when
            cars.moveAll(new ListValueGenerator(List.of(3, 3, 4)));

            // then
            Assertions.assertThat(cars.getWinners())
                    .containsExactly("honux");
        }
    }
}