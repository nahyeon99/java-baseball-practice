package baseball.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumbersTest {
    private static final int NUMBER_SIZE = 3;
    @ParameterizedTest
    @MethodSource(value = "provideBaseballNumbers")
    void calculate_strike_count(List<Integer> numbers) {
        BaseballNumbers numbersA = BaseballNumbers.userOf(numbers);
        BaseballNumbers numbersB = BaseballNumbers.userOf(numbers);

        Assertions.assertAll(
                () -> Assertions.assertTrue(numbersA.equals(numbersB)),
                () -> Assertions.assertEquals(numbersA.getStrikeCount(numbersB), NUMBER_SIZE)
        );
    }

    private static Stream<Arguments> provideBaseballNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(2, 5, 7)),
                Arguments.of(List.of(9, 5, 1))
        );
    }
}