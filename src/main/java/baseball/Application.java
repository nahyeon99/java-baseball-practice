package baseball;

import baseball.config.AppConfig;
import baseball.config.Config;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        Config config = generateConfig();
        BaseballController baseController = generateController(config);

        baseController.run();
    }

    private static Config generateConfig() {
        return AppConfig.instance();
    }

    private static BaseballController generateController(Config config) {
        return config.controller();
    }
}
