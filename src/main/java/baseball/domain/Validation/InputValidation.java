package baseball.domain.Validation;

public class InputValidation {
    private static final String NUMBER_REGEX = "[0-9]+";

    private InputValidation() {
    }

    public static boolean hasOnlyNumbers(String inputString) {
        return inputString.matches(NUMBER_REGEX);
    }

    public static boolean is3Numbers(String inputString) {
        return inputString.length() == 3;
    }
}