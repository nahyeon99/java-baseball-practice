package baseball.util;

import static baseball.exception.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputUtil {
    public static int readNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getKorean());
        }
    }

    private static String readLine() {
        String input = Console.readLine();

        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INVALID_BLANK.getKorean());
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_BLANK.getKorean());
        }
        return input;
    }
}