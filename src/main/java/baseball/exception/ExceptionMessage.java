package baseball.exception;

public enum ExceptionMessage {
    INVALID_BLANK("공백 입력은 불가능합니다."),
    INVALID_NUMBER_FORMAT("정수로 입력해 주세요."),
    ;

    private final String korean;

    ExceptionMessage(String message) {
        this.korean = message;
    }

    public String getKorean() {
        return korean;
    }
}
