package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameController gameController = new BaseballGameController();
        gameController.play();
    }
}
