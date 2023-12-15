package menu;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoachsTest {

    @DisplayName("코치 리스트에 대한 예외 발생하지 않는 테스트")
    @ParameterizedTest
    @MethodSource("coachInitSuccessProvider")
    void coachInitSuccess(List<Coachs> value) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            new Coachs(value);
        });

    }

    static Stream<Arguments> coachInitSuccessProvider() {
        return Stream.of(
                Arguments.of(List.of(new Coach("aa"), new Coach("bb"))),
                Arguments.of(List.of(new Coach("aa"), new Coach("bb"), new Coach("cc"))),
                Arguments.of(List.of(new Coach("aa"), new Coach("bb"), new Coach("cc"), new Coach("dd"), new Coach("ee")))
        );
    }

    @DisplayName("코치 리스트에 대한 예외 발생 테스트")
    @ParameterizedTest
    @MethodSource("coachInitFailProvider")
    void coachInitFail(List<Coachs> value) {
        Assertions.assertThatThrownBy(() -> new Coachs(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> coachInitFailProvider() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(new Coach("aa"))),
                Arguments.of(List.of(new Coach("aa"), new Coach("bb"), new Coach("cc"), new Coach("dd"), new Coach("ee"), new Coach("ff")))
        );
    }
}