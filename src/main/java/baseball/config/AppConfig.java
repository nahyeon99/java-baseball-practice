package baseball.config;

import baseball.controller.BaseballGameController;
import baseball.domain.Computer;
import baseball.service.DefaultHintService;
import baseball.service.HintService;
import baseball.util.RandomNumbersGenerator;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleMessageView;
import baseball.view.ConsoleResultView;
import baseball.view.InputView;
import baseball.view.MessageView;
import baseball.view.ResultView;

public class AppConfig implements Config {
    @Override
    public BaseballGameController baseballGameController() {
        return LazyHolder.baseballGameController;
    }


    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();
        private static final InputView inputView = createInputView();
        private static final MessageView messageView = createMessageView();
        private static final ResultView resultView = createResultView();
        private static final Computer computer = createComputer();
        private static final HintService hintService = createHintService();
        private static final RandomNumbersGenerator randomNumbersGenerator = createRandomNumbersGenerator();
        private static final BaseballGameController baseballGameController = createBaseballGameController();

        private static InputView createInputView() {
            return new ConsoleInputView();
        }

        private static MessageView createMessageView() {
            return new ConsoleMessageView();
        }

        private static ResultView createResultView() {
            return new ConsoleResultView();
        }

        private static Computer createComputer() {
            return new Computer(randomNumbersGenerator);
        }

        private static RandomNumbersGenerator createRandomNumbersGenerator() {
            return new RandomNumbersGenerator();
        }

        private static HintService createHintService() {
            return new DefaultHintService();
        }

        private static BaseballGameController createBaseballGameController() {
            return new BaseballGameController(inputView, messageView, resultView, hintService, computer);
        }
    }
}
