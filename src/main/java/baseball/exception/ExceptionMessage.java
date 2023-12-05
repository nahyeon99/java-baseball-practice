package baseball.exception;

public enum ExceptionMessage {
    INVALID_BLANK("필수 입력 항목입니다."),
    INVALID_NUMBER_FORMAT("정수로 입력해 주세요."),
    INVALID_NUMBERS_SIZE("숫자는 3개로 입력해 주세요."),
    INVALID_NUMBER_RANGE("숫자는 1~9 범위로 입력해 주세요."),
    INVALID_DUPLICATE_NUMBER("숫자는 중복 없이 입력해 주세요."),
    ;

    private final String korean;

    ExceptionMessage(String message) {
        this.korean = message;
    }

    public String getKorean() {
        return korean;
    }
}
