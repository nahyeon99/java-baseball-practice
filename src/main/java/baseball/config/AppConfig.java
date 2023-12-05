package baseball.config;

import baseball.controller.BaseballController;
import baseball.domain.Computer;
import baseball.generator.BaseballNumbersGenerator;
import baseball.generator.BaseballNumbersRandomGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig implements Config {

    public static AppConfig instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BaseballController baseballController() {
        return LazyHolder.baseController;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();

        private static final InputView inputView = createInputView();
        private static final OutputView ouputView = createOuputView();

        private static final BaseballNumbersGenerator baseballNumbersGenerator = createBaseballNumbersGenerator();
        private static final Computer computer = createComputer();
        private static final BaseballController baseController = createBaseController();

        private static InputView createInputView() {
            return new InputView();
        }

        private static OutputView createOuputView() {
            return new OutputView();
        }

        private static BaseballNumbersGenerator createBaseballNumbersGenerator() {
            return new BaseballNumbersRandomGenerator();
        }

        private static Computer createComputer() {
            return new Computer(baseballNumbersGenerator);
        }

        private static BaseballController createBaseController() {
            return new BaseballController(inputView, ouputView, computer);
        }
    }
}