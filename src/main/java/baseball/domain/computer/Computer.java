package baseball.domain.computer;

import baseball.domain.ball.BallCondition;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> ballNumbers;

    public Computer() {
        ballNumbers = new ArrayList<>();
    }

    public List<Integer> getBallNumbers() {
        return ballNumbers;
    }

    public void generateRandomNumbers() {
        ballNumbers.clear();

        int number;
        while (ballNumbers.size() != BallCondition.COUNT.getValue()) {
            number = Randoms.pickNumberInRange(BallCondition.MIN.getValue(), BallCondition.MAX.getValue());
            generateNumberList(number);
        }
    }

    private void generateNumberList(int number) {
        if (ballNumbers.contains(number)) {
            return;
        }
        ballNumbers.add(number);
    }

}
