package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.Computer;
import baseball.domain.HintResult;
import baseball.domain.RestartStatus;
import baseball.service.HintService;
import baseball.util.NumbersFactory;
import baseball.view.InputView;
import baseball.view.MessageView;
import baseball.view.ResultView;

public class BaseballGameController {
    private final InputView inputView;
    private final MessageView messageView;
    private final ResultView resultView;
    private final HintService hintService;
    private final Computer computer;

    public BaseballGameController(InputView inputView,
                                  MessageView messageView,
                                  ResultView resultView,
                                  HintService hintService,
                                  Computer computer) {
        this.inputView = inputView;
        this.messageView = messageView;
        this.resultView = resultView;
        this.hintService = hintService;
        this.computer = computer;
    }

    public void run() {
        welcome();

        do {
            play();
        } while (isRestart());
    }

    private void welcome() {
        messageView.printWelcomeMessage();
    }

    private void play() {
        BaseballNumbers computerNumbers = computer.createRandomNumbers();
        while (true) {
            HintResult hintResult = playOnce(computerNumbers);

            if (is3Strike(hintResult)) {
                printGameEnd();
                break;
            }
        }
    }

    private HintResult playOnce(BaseballNumbers computerNumbers) {
        BaseballNumbers userNumbers = NumbersFactory.of(inputView.inputBaseballNumbers());

        HintResult compareResult = hintService.compare(computerNumbers, userNumbers);
        printHint(compareResult);

        return compareResult;
    }

    private boolean isRestart() {
        RestartStatus restartStatus = RestartStatus.valueOf(inputView.inputRestartStatus());

        return restartStatus.equals(RestartStatus.RESTART);
    }

    private boolean is3Strike(HintResult hintResult) {
        return hintResult.is3Strike();
    }

    private void printHint(HintResult hintResult) {
        if (hintResult.isNothing()) {
            resultView.printResultOfNothing();
            return;
        }

        resultView.printResultOfBallOrStrike(hintResult.getResult());
    }

    private void printGameEnd() {
        messageView.printTerminationMessage();
    }
}