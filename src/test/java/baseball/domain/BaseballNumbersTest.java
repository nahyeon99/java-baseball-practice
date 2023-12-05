package baseball.domain;

import static baseball.domain.BaseballNumberTest.createBaseballNumbers;

import baseball.exception.ExceptionMessage;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumbersTest {

    @DisplayName(value = "BaseballNumbers 생성 시")
    @Nested
    class create_baseballnumbers {

        @ParameterizedTest
        @MethodSource(value = "baseball.domain.BaseballNumbersTest#provideNormalBaseballNumbers")
        void success(List<BaseballNumber> numbers) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> BaseballNumbers.userOf(numbers));
        }

        @ParameterizedTest
        @MethodSource(value = "baseball.domain.BaseballNumbersTest#provideDuplicateBaseballNumbers")
        void fail_by_duplicate_numbers(List<BaseballNumber> numbers) {
            Assertions.assertThatThrownBy(() -> BaseballNumbers.userOf(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.INVALID_DUPLICATE_NUMBER.getKorean());
        }

        @ParameterizedTest
        @MethodSource(value = "baseball.domain.BaseballNumbersTest#provideBaseballNumbersOutOfSize")
        void fail_by_numbers_out_of_size(List<BaseballNumber> numbers) {
            Assertions.assertThatThrownBy(() -> BaseballNumbers.userOf(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.INVALID_NUMBERS_SIZE.getKorean());
        }
    }

    static Stream<Arguments> provideNormalBaseballNumbers() {
        return Stream.of(
                Arguments.of(createBaseballNumbers(List.of(1, 2, 3))),
                Arguments.of(createBaseballNumbers(List.of(2, 6, 9))),
                Arguments.of(createBaseballNumbers(List.of(3, 9, 8)))
        );
    }

    static Stream<Arguments> provideDuplicateBaseballNumbers() {
        return Stream.of(
                Arguments.of(createBaseballNumbers(List.of(1, 3, 3))),
                Arguments.of(createBaseballNumbers(List.of(2, 9, 9))),
                Arguments.of(createBaseballNumbers(List.of(3, 3, 3)))
        );
    }

    static Stream<Arguments> provideBaseballNumbersOutOfSize() {
        return Stream.of(
                Arguments.of(createBaseballNumbers(List.of(1, 2, 4, 7, 9))),
                Arguments.of(createBaseballNumbers(List.of(2, 3, 4, 6))),
                Arguments.of(createBaseballNumbers(List.of(2)))
        );
    }
}