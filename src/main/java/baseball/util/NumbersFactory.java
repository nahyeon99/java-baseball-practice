package baseball.util;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import java.util.Arrays;
import java.util.List;

public class NumbersFactory {
    public static BaseballNumbers of(int numbers) {
        return BaseballNumbers.userOf(split(numbers));
    }

    private static List<BaseballNumber> split(int numbers) {
        return Arrays.stream(String.valueOf(numbers).split(""))
                .map(number -> BaseballNumber.userFrom(InputUtil.readNumber(number)))
                .toList();
    }
}
