package baseball.view;

import baseball.stringenum.InputExceptionCode;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_REGEX = "[0-9]+";

    public String readPlayerBallNumber() {
        System.out.println(GamePrintConstant.NUMBER_INPUT);
        return readNumbers(Console.readLine());
    }

    public String readPlayerRestart() {
        System.out.println(GamePrintConstant.RESTART);
        return readNumbers(Console.readLine());
    }

    // input 이 너무 중복된다.
    private String readNumbers(String input) {
        validateOnlyString(input);
        return input;
    }

    private void validateOnlyString(String input) {
        if (isNoneNumberIncluded(input)) {
            throw new IllegalArgumentException(InputExceptionCode.NOT_NUMBER_INCLUDE.toString());
        }
    }

    private boolean isNoneNumberIncluded(String input) {
        return !input.matches(NUMBER_REGEX);
    }
}
