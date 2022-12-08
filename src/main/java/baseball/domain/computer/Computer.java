package baseball.domain.computer;

import baseball.RandomBallGenerator;
import baseball.domain.ball.Ball;

public class Computer {
    private final Ball ball;

    public Computer() {
        this.ball = new Ball(RandomBallGenerator.generateRandomBall());
    }

}
