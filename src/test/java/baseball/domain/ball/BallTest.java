package baseball.domain.ball;

import static org.assertj.core.api.Assertions.*;

import baseball.stringenum.InputExceptionCode;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BallTest {

    @Test
    @DisplayName("볼 리스트 생성 시, 3개가 아니면 예외가 발생한다")
    void createBallsWithWrongSize() {
        List<Integer> balls = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> new Ball(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionCode.NOT_3_NUMBERS.toString());
    }

    @ParameterizedTest
    @DisplayName("볼 리스트 생성 시, 범위 외의 값이 있으면 예외가 발생한다")
    @MethodSource("provideListsForRangeOutTest")
    void createBallsOutOfRange(List<Integer> balls) {
        assertThatThrownBy(() -> new Ball(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionCode.NOT_IN_RANGE.toString());
    }

    private static Stream<List<Integer>> provideListsForRangeOutTest() {
        return Stream.of(
                List.of(0, 1, 2),
                List.of(-1, 3, 4),
                List.of(1, 2, 10)
        );
    }

    @Test
    @DisplayName("볼 리스트 생성 시, 중복값이 있으면 예외가 발생한다")
    void createBallsWithDuplication() {
        List<Integer> balls = List.of(1, 1, 2);
        assertThatThrownBy(() -> new Ball(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputExceptionCode.DUPLICATE_NUMBER.toString());
    }

    @ParameterizedTest
    @DisplayName("볼 리스트 생성 시, 정상 값이 들어오면 객체가 생성된다")
    @MethodSource("provideListsWithCorrectValue")
    void createBallsWithCorrectValue(List<Integer> balls) {
        new Ball(balls);

        // then: test pass
    }

    private static Stream<List<Integer>> provideListsWithCorrectValue() {
        return Stream.of(
                List.of(1, 2, 3),
                List.of(8, 1, 9)
        );
    }


}
