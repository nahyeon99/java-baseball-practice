package baseball.dto;

import baseball.domain.BaseballNumbers;

public record HintDto(int strikeCount, int ballCount) {

    public static HintDto of(BaseballNumbers computer, BaseballNumbers user) {
        return new HintDto(computer.getStrikeCount(user), computer.getBallCount(user));
    }

    public boolean isStrike() {
        return strikeCount > 0;
    }

    public boolean isBall() {
        return ballCount > 0;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean is3Strike() {
        return strikeCount == 3;
    }
}
