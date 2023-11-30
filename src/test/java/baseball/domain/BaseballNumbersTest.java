package baseball.domain;

import static baseball.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER;
import static baseball.exception.ExceptionMessage.INVALID_NUMBER_SIZE;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.dto.HintResultDto;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @DisplayName("BaseballNumbers 생성 시")
    @Nested
    class create_baseballNumbers {

        @DisplayName("검증을 통과하면 정상적으로 생성한다.")
        @Test
        void success() {
            List<BaseballNumber> rightNumbers = createBaseballNumbers(List.of(1, 2, 3));

            assertThatNoException().isThrownBy(() -> BaseballNumbers.userOf(rightNumbers));
        }

        @DisplayName("숫자가 3개가 아니면 예외를 발생시킨다.")
        @Test
        void fail_by_numbers_size() {
            List<BaseballNumber> failNumbers = createBaseballNumbers(List.of(1, 2, 3, 4));

            assertThatThrownBy(() -> BaseballNumbers.userOf(failNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_NUMBER_SIZE.getKorean());
        }

        @DisplayName("중복된 숫자가 있으면 예외를 발생시킨다.")
        @Test
        void fail_by_duplicate_number() {
            List<BaseballNumber> failNumbers = createBaseballNumbers(List.of(1, 1, 2));

            assertThatThrownBy(() -> BaseballNumbers.userOf(failNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_DUPLICATE_NUMBER.getKorean());
        }
    }

    @DisplayName("BaseballNumbers를 비교 시")
    @Nested
    class compare_baseballNumbers {

        @DisplayName("3 스트라이크인 두 수를 비교한다.")
        @Test
        void compare_3_strike() {
            BaseballNumbers numberA = createBaseballNumbersToObj(List.of(1, 2, 3));
            BaseballNumbers numberB = createBaseballNumbersToObj(List.of(1, 2, 3));

            HintResult matchResult = numberA.match(numberB);

            assertTrue(matchResult.is3Strike());
        }

        @DisplayName("낫싱인 경우를 비교한다.")
        @Test
        void compare_nothing() {
            BaseballNumbers numbersA = createBaseballNumbersToObj(List.of(1, 2, 3));
            BaseballNumbers numbersB = createBaseballNumbersToObj(List.of(4, 5, 6));

            HintResult matchResult = numbersA.match(numbersB);

            assertTrue(matchResult.isNothing());
        }

        @DisplayName("2볼 1 스트라이크인 경우를 비교한다.")
        @Test
        void compare_1_ball_2_strike() {
            BaseballNumbers numbersA = createBaseballNumbersToObj(List.of(1, 2, 3));
            BaseballNumbers numbersB = createBaseballNumbersToObj(List.of(2, 1, 3));

            HintResult match = numbersA.match(numbersB);
            HintResultDto result = match.getResult();

            Assertions.assertEquals(result.strikeCount(), 1);
            Assertions.assertEquals(result.ballCount(), 2);
        }
    }

    private List<BaseballNumber> createBaseballNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(BaseballNumber::userFrom)
                .toList();
    }

    private BaseballNumbers createBaseballNumbersToObj(List<Integer> numbers) {
        return BaseballNumbers.userOf(createBaseballNumbers(numbers));
    }
}