package baseball.domain.baseballNumber;

import static baseball.domain.baseballNumber.BaseballNumber.MAX_NUMBER;
import static baseball.domain.baseballNumber.BaseballNumber.MIN_NUMBER;

import baseball.exception.ExceptionMessage;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumberFactory {
    private static final int NUMBER_SIZE = 3;

    private static final List<BaseballNumber> allNumbers;

    static {
        allNumbers = BaseballNumber.allNumbersOf();
    }

    public static List<BaseballNumber> randomOf() {
        Collections.sort(allNumbers);

        return getNumbers(generateRandomNumbers());
    }

    public static List<BaseballNumber> of(final List<Integer> numbers) {
        Collections.sort(allNumbers);

        return getNumbers(numbers);
    }

    private static List<BaseballNumber> getNumbers(final List<Integer> numbers) {
        Collections.sort(allNumbers);

        try {
            return numbers.stream()
                    .map(number -> allNumbers.get(number - 1))
                    .collect(Collectors.toUnmodifiableList());
        } catch (IndexOutOfBoundsException exception) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getKorean());
        }
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}