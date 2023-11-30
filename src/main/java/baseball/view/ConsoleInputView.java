package baseball.view;

import baseball.util.InputUtil;

public class ConsoleInputView implements InputView {
    @Override
    public int inputBaseballNumbers() {
        return InputUtil.readNumber();
    }

    @Override
    public int inputRestartStatus() {
        return InputUtil.readNumber();
    }
}
