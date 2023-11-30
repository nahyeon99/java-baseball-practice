package baseball.view;

import baseball.dto.HintResultDto;

public interface ResultView {
    void printResultOfNothing();

    void printResultOfBallOrStrike(HintResultDto hintResultDto);
}
