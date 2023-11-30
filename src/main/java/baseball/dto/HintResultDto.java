package baseball.dto;

public record HintResultDto(int strikeCount, int ballCount) {

    public static HintResultDto of(int strikeCount, int ballCount) {
        return new HintResultDto(strikeCount, ballCount);
    }
}
