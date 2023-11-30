package baseball.view;

public class ConsoleMessageView implements MessageView {
    @Override
    public void printWelcomeMessage() {
        System.out.println(OutputMessage.WELCOME.korean);
    }

    @Override
    public void printTerminationMessage() {
        System.out.println(OutputMessage.TERMINATION.korean);
    }

    private enum OutputMessage {
        WELCOME("숫자 야구 게임을 시작합니다."),
        TERMINATION("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        ;

        private String korean;

        OutputMessage(String korean) {
            this.korean = korean;
        }
    }
}