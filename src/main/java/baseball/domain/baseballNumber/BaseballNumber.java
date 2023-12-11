package baseball.domain.baseballNumber;

import baseball.exception.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseballNumber implements Comparable<BaseballNumber> {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    private final int number;

    BaseballNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    static List<BaseballNumber> allNumbersOf() {
        List<BaseballNumber> allNumbers = new ArrayList<>();
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            allNumbers.add(new BaseballNumber(number));
        }
        return allNumbers;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getKorean());
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
        return Objects.equals(this.number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(BaseballNumber other) {
        return Integer.compare(this.number, other.number);
    }
}
