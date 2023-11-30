package baseball.view;

import baseball.util.InputUtil;

public class ConsoleInputView implements InputView {
    @Override
    public int inputBaseballNumbers() {
        return InputUtil.readNumber(InputUtil.readLine());
    }

    @Override
    public int inputRestartStatus() {
        return InputUtil.readNumber(InputUtil.readLine());
    }
}
