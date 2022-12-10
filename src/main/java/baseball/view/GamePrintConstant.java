package baseball.view;

import baseball.domain.ball.BallCondition;
import baseball.domain.game.Restart;

public class GamePrintConstant {
    public static final String START = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
    public static final String END = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", BallCondition.COUNT.getValue());
    public static final String RESTART = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Restart.RESTART.getValue(), Restart.END.getValue());
}
