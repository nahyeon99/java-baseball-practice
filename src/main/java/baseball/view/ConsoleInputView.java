package baseball.view;

import baseball.util.InputUtil;

public class ConsoleInputView implements InputView {
    @Override
    public int inputBaseballNumbers() {
        System.out.print(OutputMessage.INPUT_NUMBERS.korean);
        return InputUtil.readNumber(InputUtil.readLine());
    }

    @Override
    public int inputRestartStatus() {
        System.out.println(OutputMessage.INPUT_RESTART_NUMBER.korean);
        return InputUtil.readNumber(InputUtil.readLine());
    }

    private enum OutputMessage {
        INPUT_NUMBERS("숫자를 입력해주세요 : "),
        INPUT_RESTART_NUMBER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        ;

        private String korean;

        OutputMessage(String korean) {
            this.korean = korean;
        }
    }
}
