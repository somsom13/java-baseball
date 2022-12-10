package baseball.view;

import baseball.domain.hint.Hint;

public class OutputView {
    private final String  EMPTY_STRING = "";
    public void printGameStart() {
        System.out.println(GamePrintConstant.START);
    }

    public void printGameEnd() {
        System.out.println(GamePrintConstant.END);
    }

    public void printHint(Hint hint) {
        System.out.println(generateHintString(hint.getBallCount(), hint.getStrikeCount()));
    }

    private String generateHintString(int ballCount, int strikeCount) {
        StringBuilder builder = new StringBuilder();

        if (ballCount == 0 && strikeCount == 0) {
            builder.append(HintString.NOTHING.print());
            return builder.toString();
        }

        builder.append(updateBallString(ballCount));
        return updateStrikeString(strikeCount, builder);
    }

    private String updateBallString(int ballCount) {
        if (ballCount > 0) {
            return HintString.BALL.print(ballCount);
        }
        return EMPTY_STRING;
    }

    private String updateStrikeString(int strikeCount, StringBuilder builder) {
        if (strikeCount > 0) {
            builder.append(HintString.STRIKE.print(strikeCount));
        }

        if (strikeCount == 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }


}
