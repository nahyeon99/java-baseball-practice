package baseball.domain;

public enum RestartStatus {
    RESTART(1),
    END(2),
    ;

    private final int number;

    RestartStatus(int number) {
        this.number = number;
    }

    public static boolean isRestart(int number) {
        return RESTART.number == number;
    }
}