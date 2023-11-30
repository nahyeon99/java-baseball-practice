package baseball.domain;

import static baseball.exception.ExceptionMessage.INVALID_DUPLICATE_NUMBER;

import java.util.List;
import java.util.Objects;

public class BaseballNumbers {
    private static final int NUMBERS_COUNT = 3;
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
        validateDuplicateNumber(userNumbers);

        return new BaseballNumbers(userNumbers);
    }

    private static void validateDuplicateNumber(final List<BaseballNumber> numbers) {
        if (Objects.equals(NUMBERS_COUNT, numbers.stream().distinct().count())) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getKorean());
        }
    }
}