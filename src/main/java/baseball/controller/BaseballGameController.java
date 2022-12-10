package baseball.controller;

import baseball.domain.game.BaseballGame;
import baseball.domain.hint.Hint;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballGame baseballGame;

    public BaseballGameController() {
        this.inputView = new InputView();
        this.baseballGame = new BaseballGame();
        this.outputView = new OutputView();
    }

    public void play() {
        outputView.printGameStart();
        while (baseballGame.isGamePlaying()) {
            Hint hint = baseballGame.playNewTurn(generateBalls(inputView.readPlayerBallNumber()));
            //hint 출력
            checkGameEnd();
        }
        outputView.printGameEnd();
    }

    private List<Integer> generateBalls(String input) {
        List<Integer> balls = new ArrayList<>();
        for (char number : input.toCharArray()) {
            balls.add(number - '0');
        }
        return balls;
    }

    private void checkGameEnd() {
        if (baseballGame.isGamePlaying()) {
            return;
        }
        requestRestart(inputView.readPlayerRestart());
    }

    private void requestRestart(String restartInput) {
        baseballGame.restart(restartInput);
    }
}
