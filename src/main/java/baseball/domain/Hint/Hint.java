package baseball.domain.Hint;

import java.util.List;
import java.util.stream.Collectors;

public class Hint {
    private int ball;
    private int strike;

    public Hint() {
        this.ball = 0;
        this.strike = 0;
    }

    public String printHint(List<Integer> playerBalls, List<Integer> computerBalls) {
        determineBallStrike(playerBalls, computerBalls);
        return printStatement();
    }

    private void determineBallStrike(List<Integer> playerBalls, List<Integer> computerBalls) {
        List<Integer> canBeBall = ballCount(playerBalls, computerBalls);
        canBeBall.forEach(ball -> strikeCall(ball, playerBalls, computerBalls));
    }

    private List<Integer> ballCount(List<Integer> playerBalls, List<Integer> computerBalls) {
        List<Integer> canBeBall = playerBalls.stream()
                .filter(computerBalls::contains)
                .collect(Collectors.toList());
        ball = canBeBall.size();
        return canBeBall;
    }

    private void strikeCall(int nowBall, List<Integer> playerBalls, List<Integer> computerBalls) {
        if (playerBalls.indexOf(nowBall) == computerBalls.indexOf(nowBall)) {
            strike++;
            ball--;
        }
    }

    private String printStatement() {
        StringBuilder sb = new StringBuilder();

        if (ball == 0 && strike == 0) {
            sb.append(HintString.NOTHING.print());
            return sb.toString();
        }

        if (ball > 0) {
            sb.append(HintString.BALL.print(ball));
        }

        if (strike > 0) {
            sb.append(HintString.STRIKE.print(strike));
        }

        return sb.toString();
    }
}
