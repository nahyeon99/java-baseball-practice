package baseball;

import baseball.config.AppConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = AppConfig.instance();
        BaseballController baseballController = config.baseballController();

        baseballController.run();
    }
}
