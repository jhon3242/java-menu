package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @DisplayName("코치 이름에 대한 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  ", "a", "aaaaa"})
    void coachInitFail(String value) {
        Assertions.assertThatThrownBy(() -> new Coach(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름에 대한 예외 발생하지 않는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "aaaa", "포비", "타칸", "코치이름"})
    void coachInitSuccess(String value) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            new Coach(value);
        });
    }
}