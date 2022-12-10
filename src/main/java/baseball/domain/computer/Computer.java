package baseball.domain.computer;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallJudgement;

public class Computer {
    private final Ball ball;

    public Computer(Ball ball) {
        this.ball = ball;
    }
    public BallJudgement judgePitchBall(int position, int value) {
        return ball.judgeBallPitch(position, value);
    }

}
