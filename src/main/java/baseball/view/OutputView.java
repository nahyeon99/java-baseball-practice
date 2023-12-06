package baseball.view;

import baseball.dto.ResultDto;

public class OutputView {

    public void printGameStart() {
        System.out.println(Message.GAME_START.korean);
    }

    public void printHint(ResultDto result) {
        if (result.isZeroFromStrike() && result.isZeroFromBall()) {
            System.out.println(Message.NOTHING.korean);
            return;
        }

        if (!result.isZeroFromBall()) {
            System.out.printf(Message.BALL_FORMAT.korean, result.ballCount());
        }

        if (!result.isZeroFromStrike()) {
            System.out.printf(Message.STRIKE_FORMAT.korean, result.strikeCount());
        }
        System.out.println();
    }

    public void printGameFinish() {
        System.out.println(Message.GAME_FINISHED.korean);
    }

    private enum Message {
        GAME_START("숫자 야구 게임을 시작합니다."),
        GAME_FINISHED("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        BALL_AND_STRIKE_FORMAT("%볼%스트라이크"),
        BALL_FORMAT("%d볼 "),
        STRIKE_FORMAT("%d스트라이크"),
        NOTHING("낫싱"),
        ;
        private String korean;

        Message(String korean) {
            this.korean = korean;
        }
    }
}