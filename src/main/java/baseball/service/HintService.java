package baseball.service;

import baseball.domain.BaseballNumbers;
import baseball.domain.HintResult;

public interface HintService {
    HintResult compare(BaseballNumbers computer, BaseballNumbers user);
}
