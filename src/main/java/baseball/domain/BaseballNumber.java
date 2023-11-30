package baseball.domain;

import static baseball.exception.ExceptionMessage.INVALID_NUMBER_RANGE;

import java.util.Objects;

public class BaseballNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    private BaseballNumber(int number) {
        this.number = number;
    }

    public static BaseballNumber computerFrom(int number) {
        return new BaseballNumber(number);
    }

    public static BaseballNumber userFrom(int number) {
        validateNumberRange(number);
        return new BaseballNumber(number);
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getKorean());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BaseballNumber)) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) other;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
