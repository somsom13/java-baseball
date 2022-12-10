package baseball.domain.computer;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallJudgement;

public class Computer {
    private Ball ball;

    public Computer() {
    }
    public BallJudgement judgePitchBall(int position, int value) {
        return ball.judgeBallPitch(position, value);
    }

    public void updateNewComputerBall(Ball ball) {
        this.ball = ball;
    }

}
