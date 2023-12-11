package baseball.domain.baseballNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumberFactoryTest {
    private static final int NUMBER_SIZE = 3;

    @DisplayName("랜덤으로 숫자 생성 시 중복 없는 3개의 숫자를 생성한다.")
    @Test
    void random_of() {
        List<BaseballNumber> baseballNumbers = BaseballNumberFactory.randomOf();

        int distinctCount = (int) baseballNumbers.stream().distinct().count();

        Assertions.assertAll(
                () -> Assertions.assertEquals(distinctCount, baseballNumbers.size()),
                () -> Assertions.assertEquals(distinctCount, NUMBER_SIZE)
        );

    }

    @DisplayName("입력받은 숫자로 숫자 야구 생성 시 올바른 숫자를 생성한다.")
    @ParameterizedTest
    @MethodSource(value = "provideNumbers")
    void of(List<Integer> numbers) {
        List<Integer> nums = new ArrayList<>(numbers);

        List<BaseballNumber> baseballNumbers = BaseballNumberFactory.of(nums);

        int sameCount = (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> baseballNumbers.get(idx).equals(new BaseballNumber(nums.get(idx))))
                .count();

        Assertions.assertEquals(NUMBER_SIZE, sameCount);
    }

    static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(5, 9, 2))
        );
    }
}