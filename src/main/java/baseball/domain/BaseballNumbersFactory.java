package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbersFactory {
    public static BaseballNumbers generate(List<Integer> numbers) {
        return BaseballNumbers.userOf(generateBaseballNumber(numbers));
    }

    private static List<BaseballNumber> generateBaseballNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(BaseballNumber::userFrom)
                .collect(Collectors.toUnmodifiableList());
    }
}