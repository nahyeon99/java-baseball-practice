package baseball.exception;

public enum ExceptionMessage {
    INVALID_BLANK("공백 입력은 불가능합니다."),
    INVALID_NUMBER_FORMAT("정수로 입력해 주세요."),
    INVALID_NUMBER_RANGE("숫자는 1~9 범위 내에서 입력해 주세요."),
    INVALID_DUPLICATE_NUMBER("숫자 중복 없이 입력해 주세요."),
    INVALID_NUMBER_SIZE("세 자리 숫자로 입력해 주세요."),
    INVALID_RESTART_STATUS("재시작 여부는 1 또는 2로 입력해 주세요."),
    ;

    private final String korean;

    ExceptionMessage(String message) {
        this.korean = message;
    }

    public String getKorean() {
        return korean;
    }
}
