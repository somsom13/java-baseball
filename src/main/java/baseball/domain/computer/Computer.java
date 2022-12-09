package baseball.domain.computer;

import baseball.RandomBallGenerator;
import baseball.domain.ball.Ball;
import baseball.domain.ball.BallJudgement;

public class Computer {
    private final Ball ball;

    public Computer() {
        this.ball = new Ball(RandomBallGenerator.generateRandomBall());
    }

    public BallJudgement calculateHint(int position, int number) {
        return ball.judgeBallPitch(position, number);
    }

}
