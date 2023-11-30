package baseball.domain;

import static baseball.exception.ExceptionMessage.INVALID_RESTART_STATUS;

import java.util.Arrays;

public enum RestartStatus {
    RESTART(1),
    END(2),
    ;

    private final int number;

    RestartStatus(int number) {
        this.number = number;
    }

    public static RestartStatus valueOf(int number) {
        return Arrays.stream(values())
                .filter(value -> value.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_RESTART_STATUS.getKorean()));
    }
}