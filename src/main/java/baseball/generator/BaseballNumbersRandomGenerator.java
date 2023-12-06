package baseball.generator;

import baseball.domain.BaseballNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseballNumbersRandomGenerator implements BaseballNumbersGenerator {
    @Override
    public BaseballNumbers generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        return BaseballNumbers.computerOf(numbers);
    }
}
