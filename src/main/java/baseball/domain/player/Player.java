package baseball.domain.player;

import baseball.domain.ball.Ball;
import java.util.List;

public class Player {
    private Ball ball;

    public Player() {
    }

    public void updatePlayerBall(Ball ball) {
        this.ball = ball;
    }

    public List<Integer> getPlayerBall() {
        return ball.getBallNumbers();
    }
}
