package baseball.domain.hint;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.ball.BallJudgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
    private Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @DisplayName("스트라이크 일 때 strikeCount 가 증가한다")
    @Test
    void strikeCountIncrease() {
        hint.updateBallCount(BallJudgement.STRIKE);
        assertAll(
                () -> assertThat(hint.getStrikeCount()).isEqualTo(1),
                () -> assertThat(hint.getBallCount()).isEqualTo(0)
        );
    }

    @DisplayName("볼 일 때 ballCount 가 증가한다")
    @Test
    void ballCountIncrease() {
        hint.updateBallCount(BallJudgement.BALL);
        assertAll(
                () -> assertThat(hint.getStrikeCount()).isEqualTo(0),
                () -> assertThat(hint.getBallCount()).isEqualTo(1)
        );
    }

    @DisplayName("미스일 때 strike 와 ball 모두 증가하지 않는다")
    @Test
    void missNoneIncrease() {
        hint.updateBallCount(BallJudgement.MISS);
        assertAll(
                () -> assertThat(hint.getStrikeCount()).isEqualTo(0),
                () -> assertThat(hint.getBallCount()).isEqualTo(0)
        );
    }
}
