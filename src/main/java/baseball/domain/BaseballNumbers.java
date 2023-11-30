package baseball.domain;

import static baseball.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER;
import static baseball.exception.ExceptionMessage.INVALID_NUMBER_SIZE;

import baseball.dto.HintResultDto;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int MAX_NUMBERS_COUNT = 3;
    private static final int RANGE_ZERO = 0;
    private final List<BaseballNumber> numbers;

    private BaseballNumbers(final List<BaseballNumber> numbers) {
        this.numbers = numbers;
    }

    public static BaseballNumbers computerOf(final List<Integer> computerNumbers) {
        List<BaseballNumber> computers = computerNumbers.stream()
                .map(BaseballNumber::computerFrom)
                .toList();

        return new BaseballNumbers(computers);
    }

    public static BaseballNumbers userOf(final List<BaseballNumber> userNumbers) {
        validateNumberSize(userNumbers);
        validateDuplicateNumber(userNumbers);

        return new BaseballNumbers(userNumbers);
    }

    public HintResult match(BaseballNumbers others) {
        int strikeCount = getStrikeCount(others);
        int ballCount = getBallCount(others);

        return HintResult.of(HintResultDto.of(strikeCount, ballCount));
    }

    private static void validateDuplicateNumber(final List<BaseballNumber> numbers) {
        if (!Objects.equals(MAX_NUMBERS_COUNT, (int) numbers.stream().distinct().count())) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getKorean());
        }
    }

    private static void validateNumberSize(final List<BaseballNumber> numbers) {
        if (numbers.size() != MAX_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getKorean());
        }
    }

    private int getStrikeCount(BaseballNumbers other) {
        return (int) IntStream.range(RANGE_ZERO, MAX_NUMBERS_COUNT)
                .filter(idx -> numbers.get(idx).equals(other.numbers.get(idx)))
                .count();
    }

    private int getBallCount(BaseballNumbers other) {
        return (int) IntStream.range(RANGE_ZERO, MAX_NUMBERS_COUNT)
                .filter(idx -> {
                    BaseballNumber otherNumber = other.numbers.get(idx);

                    return !numbers.get(idx).equals(otherNumber) &&
                            numbers.contains(otherNumber);
                })
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
        return MAX_NUMBERS_COUNT == (int) IntStream.range(RANGE_ZERO, MAX_NUMBERS_COUNT)
                .filter(idx -> numbers.get(idx).equals(that.numbers.get(idx)))
                .count();
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}