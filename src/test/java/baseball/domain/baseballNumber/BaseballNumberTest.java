package baseball.domain.baseballNumber;

import baseball.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @DisplayName("BaseballNumber 생성 시")
    @Nested
    class create_baseball_number {

        @DisplayName("정상적으로 생성한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 3, 9})
        void success(int number) {
            Assertions.assertThatNoException().isThrownBy(() -> new BaseballNumber(number));
        }

        @DisplayName("1~9 범위 밖의 숫자로 생성 시 예외를 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 10})
        void fail_by_range(int number) {
            Assertions.assertThatThrownBy(() -> new BaseballNumber(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_RANGE.getKorean());
        }
    }
}