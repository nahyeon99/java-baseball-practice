package baseball.view;

import baseball.dto.HintDto;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(Message.GAME_START.korean);
    }

    public void printHintResult(HintDto hint) {
        if (hint.isNothing()) {
            System.out.println(Message.NOTHING.korean);
            return;
        }

        System.out.println(getStrikeOrBall(hint));
        printFinishMessage(hint);
    }

    private String getStrikeOrBall(HintDto hint) {
        String result = "";
        if (hint.isBall()) {
            result = hint.ballCount() + Message.BALL.korean;
        }
        if (hint.isStrike()) {
            result = result + hint.strikeCount() + Message.STRIKE.korean;
        }
        return result;
    }

    private void printFinishMessage(HintDto hint) {
        if (hint.is3Strike()) {
            System.out.println(Message.FINISH_GAME.korean);
        }
    }


    private enum Message {
        GAME_START("숫자 야구 게임을 시작합니다."),
        STRIKE("스트라이크"),
        BALL("볼 "),
        NOTHING("낫싱"),
        FINISH_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
        ;
        private String korean;

        Message(String korean) {
            this.korean = korean;
        }
    }
}
