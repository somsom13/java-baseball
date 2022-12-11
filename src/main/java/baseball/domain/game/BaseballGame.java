package baseball.domain.game;

import baseball.RandomBallGenerator;
import baseball.domain.ball.Ball;
import baseball.domain.computer.Computer;
import baseball.domain.hint.Hint;
import baseball.domain.player.Player;
import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private boolean isPlaying;
    private Hint hint;

    public BaseballGame() {
        computer = new Computer();
        player = new Player();
        isPlaying = true;
        setNewGame();
    }

    public Hint playNewTurn(List<Integer> balls) {
        player.updatePlayerBall(new Ball(balls));
        calculateHint(player.getPlayerBall());
        checkGameSuccess();
        return hint;
    }

    public void restart(String restartInput) {
        isPlaying = Restart.isRestart(restartInput);
        if (isPlaying) {
            setNewGame();
        }
    }

    public boolean isGamePlaying() {
        return isPlaying;
    }

    private void calculateHint(List<Integer> playerBalls) {
        hint = new Hint();
        for (int position = 0; position < playerBalls.size(); position++) {
            hint.updateBallCount(computer.judgePitchBall(position, playerBalls.get(position)));
        }
    }

    private void checkGameSuccess() {
        if (hint.is3Strike()) {
            isPlaying = false;
        }
    }

    private void setNewGame() {
        this.computer.updateNewComputerBall(new Ball(RandomBallGenerator.generateRandomBall()));
    }

}
