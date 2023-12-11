package baseball.config;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig implements Config {

    public static AppConfig instance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BaseballController controller() {
        return LazyHolder.baseballController;
    }

    private static class LazyHolder {
        private static final AppConfig INSTANCE = new AppConfig();

        private static final InputView inputView = createInputView();
        private static final OutputView ouputView = createOuputView();

        private static final BaseballController baseballController = createBaseseballController();

        private static InputView createInputView() {
            return new InputView();
        }

        private static OutputView createOuputView() {
            return new OutputView();
        }

        private static BaseballController createBaseseballController() {
            return new BaseballController(inputView, ouputView);
        }
    }
}
