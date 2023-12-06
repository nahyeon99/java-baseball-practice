package baseball.view;

import static baseball.util.InputUtil.readLine;
import static baseball.util.InputUtil.readNumber;
import static baseball.util.InputUtil.readNumbers;

import java.util.List;

public class InputView {

    public List<Integer> inputBaseballNumbers() {
        System.out.print(Message.INPUT_BASEBALL_NUMBERS.korean);

        return readNumbers(readLine(), Message.BASEBALL_NUMBER_DELIMITER.korean);
    }

    public int inputRestartNumber() {
        System.out.println(Message.INPUT_RESTART_OR_QUIT_NUMBER.korean);

        return readNumber(readLine());
    }

    private enum Message {
        INPUT_BASEBALL_NUMBERS("숫자를 입력해주세요 : "),
        INPUT_RESTART_OR_QUIT_NUMBER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        BASEBALL_NUMBER_DELIMITER(""),
        ;
        private String korean;

        Message(String korean) {
            this.korean = korean;
        }
    }
}