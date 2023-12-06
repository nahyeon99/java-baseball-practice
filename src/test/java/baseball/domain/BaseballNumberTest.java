package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.exception.ExceptionMessage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "2, 2", "3, 3"})
    void compare_equals(int num1, int num2) {
        BaseballNumber baseballNumber1 = BaseballNumber.userFrom(num1);
        BaseballNumber baseballNumber2 = BaseballNumber.userFrom(num2);

        assertEquals(baseballNumber1, baseballNumber2);
    }

    @DisplayName(value = "BaseballNumber 생성 시")
    @Nested
    class create_baseballnumber {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
        void success(int number) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> {
                        BaseballNumber.userFrom(number);
                        BaseballNumber.computerFrom(number);
                    });
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 10, -1})
        void fail_by_range(int number) {
            Assertions.assertThatThrownBy(() -> BaseballNumber.userFrom(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_RANGE.getKorean());
        }
    }

    static List<BaseballNumber> createBaseballNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(BaseballNumber::userFrom)
                .toList();
    }

}