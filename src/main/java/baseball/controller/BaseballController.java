package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersFactory;
import baseball.domain.Computer;
import baseball.domain.RestartStatus;
import baseball.dto.ResultDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public BaseballController(InputView inputView,
                              OutputView outputView,
                              Computer computer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
    }

    public void run() {
        do {
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        BaseballNumbers computerNumbers = computer.generate();

        while (true) {
            ResultDto result = playGameOnce(computerNumbers);

            if (result.is3Strike()) {
                break;
            }
        }
    }

    private ResultDto playGameOnce(BaseballNumbers computerNumbers) {
        BaseballNumbers userNumbers = BaseballNumbersFactory.generate(inputView.inputBaseballNumbers());

        return ResultDto.of(computerNumbers.getStrikeCount(userNumbers),
                computerNumbers.getBallCount(userNumbers));
    }

    private boolean isRestart() {
        return RestartStatus.isRestart(inputView.inputRestartNumber());
    }
}
