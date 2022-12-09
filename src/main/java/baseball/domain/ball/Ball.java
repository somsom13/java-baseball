package baseball.domain.ball;

import baseball.stringenum.InputExceptionCode;
import java.util.Collections;
import java.util.List;

// 단 하나의 컬렉션을 필드로 가지며 볼 리스트에 대해 공통적으로 수행되는 작업을 묶은 일급 컬렉션
public class Ball {
    private final List<Integer> balls;

    public Ball(List<Integer> balls) {
        validate(balls);
        this.balls = balls;
    }

    public BallJudgement judgeBallPitch(int position, int value) {
        if (isStrike(position, value)) {
            return BallJudgement.STRIKE;
        }
        if (isBall(value)) {
            return BallJudgement.BALL;
        }
        return BallJudgement.MISS;
    }

    public List<Integer> getBallNumbers() {
        return Collections.unmodifiableList(balls);
    }

    private void validate(List<Integer> balls) {
        validateSize(balls);
        validateAllInRange(balls);
        validateDuplication(balls);
    }

    private void validateSize(List<Integer> balls) {
        if (is3Numbers(balls.size())) {
            return;
        }
        throw new IllegalArgumentException(InputExceptionCode.NOT_3_NUMBERS.toString());
    }

    private void validateAllInRange(List<Integer> balls) {
        if (isNumberInRange(balls)) {
            return;
        }
        throw new IllegalArgumentException(InputExceptionCode.NOT_IN_RANGE.toString());
    }

    private void validateDuplication(List<Integer> balls) {
        if (isDuplicate(balls)) {
            throw new IllegalArgumentException(InputExceptionCode.DUPLICATE_NUMBER.toString());
        }
    }

    private boolean is3Numbers(int size) {
        return size == BallCondition.COUNT.getValue();
    }

    private boolean isDuplicate(List<Integer> balls) {
        return BallCondition.COUNT.getValue()
                != balls.stream()
                .distinct()
                .count();
    }

    private boolean isNumberInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isInRange);
    }

    private boolean isInRange(int number) {
        return number >= BallCondition.MIN.getValue() && number <= BallCondition.MAX.getValue();
    }

    private boolean isStrike(int position, int value) {
        return balls.get(position) == value;
    }

    private boolean isBall(int value) {
        return balls.contains(value);
    }

}
