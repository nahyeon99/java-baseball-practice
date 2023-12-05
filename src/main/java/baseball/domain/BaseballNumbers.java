package baseball.domain;

import baseball.exception.ExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int NUMBERS_SIZE = 3;

    private final List<BaseballNumber> numbers;

    private BaseballNumbers(final List<BaseballNumber> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumbers computerOf(final List<Integer> numbers) {
        List<BaseballNumber> computerNumbers = numbers.stream()
                .map(BaseballNumber::computerFrom)
                .collect(Collectors.toUnmodifiableList());

        return new BaseballNumbers(computerNumbers);
    }

    public static BaseballNumbers userOf(final List<BaseballNumber> numbers) {
        validateNumbersSize(numbers.size());
        validateDuplicateNumber(numbers);

        return new BaseballNumbers(numbers);
    }

    public int getStrikeCount(BaseballNumbers other) {
        return (int) IntStream.range(0, NUMBERS_SIZE)
                .filter(idx -> compareTo(numbers.get(idx), other.numbers.get(idx)))
                .count();
    }

    public int getBallCount(BaseballNumbers other) {
        return (int) IntStream.range(0, NUMBERS_SIZE)
                .filter(idx -> !compareTo(numbers.get(idx), other.numbers.get(idx)) &&
                        contains(other.numbers.get(idx)))
                .count();
    }

    private static void validateNumbersSize(int size) {
        if (size != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBERS_SIZE.getKorean());
        }
    }

    private static void validateDuplicateNumber(final List<BaseballNumber> numbers) {
        if ((int) numbers.stream().distinct().count() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_DUPLICATE_NUMBER.getKorean());
        }
    }

    private boolean compareTo(BaseballNumber number, BaseballNumber other) {
        return number.equals(other);
    }

    private boolean contains(BaseballNumber baseballNumber) {
        return numbers.contains(baseballNumber);
    }
}
