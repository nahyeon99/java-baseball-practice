package baseball.view;

import baseball.dto.HintResultDto;

public class ConsoleResultView implements ResultView {
    @Override
    public void printResultOfNothing() {
        System.out.println(OutputMessage.NOTHING);
    }

    @Override
    public void printResultOfBallOrStrike(HintResultDto hintResultDto) {
        int strike = hintResultDto.strikeCount();
        int ball = hintResultDto.ballCount();

        if (strike > 0 && ball > 0) {
            printBallAndStrike(ball, strike);
            return;
        }

        if (strike > 0) {
            printStrike(strike);
            return;
        }

        printBall(ball);
    }

    private void printBallAndStrike(int ball, int strike) {
        System.out.printf(OutputMessage.STRIKE_BALL_FORMAT.korean, ball, strike);
        System.out.println();
    }

    private void printStrike(int strike) {
        System.out.printf(OutputMessage.STRIKE_FORMAT.korean, strike);
        System.out.println();
    }

    private void printBall(int ball) {
        System.out.printf(OutputMessage.BALL_FORMAT.korean, ball);
        System.out.println();
    }

    private enum OutputMessage {
        NOTHING("낫싱"),
        STRIKE_BALL_FORMAT("%d볼 %d스트라이크"),
        BALL_FORMAT("%d볼"),
        STRIKE_FORMAT("%d스트라이크"),
        ;

        private String korean;

        OutputMessage(String korean) {
            this.korean = korean;
        }
    }
}