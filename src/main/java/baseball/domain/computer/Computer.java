package baseball.domain.computer;

import baseball.RandomBallGenerator;
import baseball.domain.ball.Ball;
import baseball.domain.ball.BallJudgement;

public class Computer {
    private final Ball ball;

    public Computer() {
        this.ball = new Ball(RandomBallGenerator.generateRandomBall());
    }
    public BallJudgement judgePitchBall(int position, int value) {
        return ball.judgeBallPitch(position, value);
    }

}
