package baseball.domain.hint;

import baseball.domain.ball.BallJudgement;

public class Hint {
    private int ballCount;
    private int strikeCount;

    public Hint() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void updateBallCount(BallJudgement judgement) {
        if (judgement == BallJudgement.STRIKE) {
            strikeCount++;
        }
        if (judgement == BallJudgement.BALL) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
