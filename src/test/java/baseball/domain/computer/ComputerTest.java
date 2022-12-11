package baseball.domain.computer;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.ball.Ball;
import baseball.domain.ball.BallJudgement;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.updateNewComputerBall(new Ball(List.of(1, 2, 3)));
    }

    @Test
    @DisplayName("위치가 같고 값이 다르다면 BALL 로 판정된다")
    void playerBallWithDiffPositionSameValue() {
        int position = 2;
        int value = 1;
        assertThat(computer.judgePitchBall(position, value)).isEqualTo(BallJudgement.BALL);
    }

    @Test
    @DisplayName("위치와 값이 동일하다면 STRIKE 로 판정된다")
    void playerBallWithSameValuePosition() {
        int position = 2;
        int value = 3;
        assertThat(computer.judgePitchBall(position, value)).isEqualTo(BallJudgement.STRIKE);
    }

    @Test
    @DisplayName("위치와 값이 모두 다르다면 MISS 로 판정된다")
    void playerBallWithDiffValuePosition() {
        int position = 1;
        int value = 4;
        assertThat(computer.judgePitchBall(position, value)).isEqualTo(BallJudgement.MISS);
    }

}