package baseball.domain.game;

import baseball.stringenum.InputExceptionCode;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Restart {
    RESTART("1", true),
    END("2", false);

    private final String value;
    private final boolean restart;
    private static final Map<String, Boolean> VALUE_RESTART_MAP =
            Stream.of(values()).collect(Collectors.toMap(Restart::getValue, Restart::getRestart));

    Restart(String value, boolean restart) {
        this.value = value;
        this.restart = restart;
    }

    public static Boolean isRestart(String value) {
        validateRestart(value);
        return VALUE_RESTART_MAP.get(value);
    }

    public String getValue() {
        return value;
    }

    private boolean getRestart() {
        return restart;
    }

    private static void validateRestart(String value) {
        if (VALUE_RESTART_MAP.containsKey(value)) {
            return;
        }
        throw new IllegalArgumentException(InputExceptionCode.NOT_RESTART_NUMBER.toString());
    }
}
