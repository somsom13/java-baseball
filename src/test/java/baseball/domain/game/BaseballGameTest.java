package baseball.domain.game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballGameTest {
    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame();
    }

    @DisplayName("재시작 여부에 따라 게임 진행 상태가 변화한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void gamePlayingStatusByRestartInput(String input, boolean isPlaying) {
        baseballGame.restart(input);

        assertThat(baseballGame.isGamePlaying()).isEqualTo(isPlaying);
    }
}