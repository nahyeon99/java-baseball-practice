package baseball.domain;

import baseball.exception.ExceptionMessage;
import java.util.Arrays;

public enum RestartStatus {
    RESTART(1),
    END(2),
    ;

    private final int inputNumber;

    RestartStatus(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static boolean isRestart(int number) {
        RestartStatus restartStatus = Arrays.stream(values())
                .filter(value -> value.inputNumber == number)
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(ExceptionMessage.INVALID_RESTART_STATUS_NUMBER.getKorean()));

        return restartStatus == RESTART;
    }
}
