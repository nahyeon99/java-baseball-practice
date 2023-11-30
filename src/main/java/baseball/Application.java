package baseball;

import baseball.config.AppConfig;
import baseball.config.Config;
import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        BaseballGameController baseballGameController = generateController(config);

        baseballGameController.run();
    }

    private static Config generateConfig() {
        return AppConfig.instance();
    }

    private static BaseballGameController generateController(Config config) {
        return config.baseballGameController();
    }
}
