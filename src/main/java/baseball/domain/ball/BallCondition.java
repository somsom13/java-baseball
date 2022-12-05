package baseball.domain.ball;

public enum BallCondition {
    MIN(1),
    MAX(9),
    COUNT(3);

    private final int value;

    BallCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
