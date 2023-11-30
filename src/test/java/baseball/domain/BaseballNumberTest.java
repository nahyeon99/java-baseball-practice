package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @DisplayName("숫자의 범위가 1~9가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void fail_by_number_size(int number) {
        assertThatThrownBy(() -> BaseballNumber.userFrom(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_RANGE.getKorean());
    }

    @DisplayName("동일한 숫자는 객체의 동일성을 보장한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    void equals_of_same_number(int number) {
        assertEquals(BaseballNumber.userFrom(number), BaseballNumber.computerFrom(number));
    }
}