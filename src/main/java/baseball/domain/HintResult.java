package baseball.domain;

import baseball.dto.HintResultDto;
import java.util.EnumMap;
import java.util.Map;

public class HintResult {
    private final Map<Hint, Integer> result;

    private HintResult(Map<Hint, Integer> result) {
        this.result = result;
    }

    public static HintResult of(HintResultDto hints) {
        Map<Hint, Integer> result = new EnumMap<>(Hint.class);

        result.put(Hint.STRIKE, hints.strikeCount());
        result.put(Hint.BALL, hints.ballCount());

        return new HintResult(result);
    }

    public boolean isNothing() {
        return result.get(Hint.STRIKE).equals(0) && result.get(Hint.BALL).equals(0);
    }

    public HintResultDto getResult() {
        return HintResultDto.of(result.get(Hint.STRIKE), result.get(Hint.BALL));
    }

    public boolean is3Strike() {
        return result.get(Hint.STRIKE) == 3;
    }
}