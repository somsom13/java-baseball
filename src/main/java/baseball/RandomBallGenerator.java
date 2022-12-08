package baseball;

import baseball.domain.ball.BallCondition;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomBallGenerator {
    private static boolean[] isPickedNumber;

    private RandomBallGenerator() {
    }

    public static List<Integer> generateRandomBall() {
        List<Integer> balls = new ArrayList<>();
        isPickedNumber = new boolean[10];
        while (balls.size() < BallCondition.COUNT.getValue()) {
            balls.add(pickNonDuplicateNumber());
        }
        return balls;
    }

    private static int pickNonDuplicateNumber() {
        int number;
        while (true) {
            number = generateRandomNumber();
            if (isPickedNumber[number]) {
                continue;
            }
            isPickedNumber[number] = true;
            return number;
        }
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(BallCondition.MIN.getValue(), BallCondition.MAX.getValue());
    }
}
