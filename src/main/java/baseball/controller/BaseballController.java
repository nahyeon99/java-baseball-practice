package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.RestartStatus;
import baseball.dto.HintDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView,
                              OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStartMessage();
        do {
            play();
        } while (isRestart());
    }

    private void play() {
        BaseballNumbers computerNumbers = generateComputerNumbers();

        while (true) {
            BaseballNumbers userNumbers = BaseballNumbers.userOf(inputView.inputBaseballNumbers());
            outputView.printHintResult(HintDto.of(computerNumbers, userNumbers));

            if (computerNumbers.equals(userNumbers)) {
                break;
            }
        }
    }

    private BaseballNumbers generateComputerNumbers() {
        return BaseballNumbers.computerOf();
    }

    private boolean isRestart() {
        return RestartStatus.isRestart(inputView.inputRestartStatus());
    }
}
