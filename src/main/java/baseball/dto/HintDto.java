package baseball.dto;

public record HintDto(int strikeCount, int ballCount) {

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
