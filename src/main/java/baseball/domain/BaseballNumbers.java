package baseball.domain;

import baseball.domain.baseballNumber.BaseballNumber;
import baseball.domain.baseballNumber.BaseballNumberFactory;
import baseball.exception.ExceptionMessage;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int NUMBER_SIZE = 3;

    private final List<BaseballNumber> numbers;

    private BaseballNumbers(List<BaseballNumber> numbers) {
        validateNumberSize(numbers.size());
        this.numbers = numbers;
    }

    public static BaseballNumbers computerOf() {
        return new BaseballNumbers(BaseballNumberFactory.randomOf());
    }

    public static BaseballNumbers userOf(List<Integer> numbers) {
        return new BaseballNumbers(BaseballNumberFactory.of(numbers));
    }

    public int getStrikeCount(BaseballNumbers other) {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> numbers.get(idx).equals(other.numbers.get(idx)))
                .count();
    }

    public int getBallCount(BaseballNumbers other) {
        return (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> !numbers.get(idx).equals(other.numbers.get(idx)) &&
                        numbers.contains(other.numbers.get(idx)))
                .count();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseballNumbers)) {
            return false;
        }
        BaseballNumbers that = (BaseballNumbers) other;
        return NUMBER_SIZE == (int) IntStream.range(0, NUMBER_SIZE)
                .filter(idx -> numbers.get(idx).equals(that.numbers.get(idx)))
                .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    private void validateNumberSize(int size) {
        if (size != NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_SIZE.getKorean());
        }
    }
}
