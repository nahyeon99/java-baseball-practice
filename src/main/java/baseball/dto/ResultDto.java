package baseball.dto;

public record ResultDto(int strikeCount, int ballCount) {
    public static ResultDto of(int strikeCount, int ballCount) {
        return new ResultDto(strikeCount, ballCount);
    }

    public boolean isZeroFromStrike() {
        return strikeCount == 0;
    }

    public boolean isZeroFromBall() {
        return ballCount == 0;
    }

    public boolean is3Strike() {
        return strikeCount == 3;
    }
}