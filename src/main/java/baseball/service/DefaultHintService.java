package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.domain.HintResult;

public class DefaultHintService implements HintService {
    @Override
    public HintResult compare(BaseballNumbers computer, BaseballNumbers user) {
        return computer.match(user);
    }
}
