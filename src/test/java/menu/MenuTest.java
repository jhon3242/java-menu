package menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @DisplayName("추천할 수 있는 메뉴를 랜덤으로 가져온다.")
    @RepeatedTest(20)
    void getRandomMenu() {
        Coach coach = new Coach("코치");

        coach.addExceptionMenu("규동");
        coach.addExceptionMenu("우동");
        coach.addAteMenu("미소시루");

        String randomMenu = Menu.getRandomMenu(coach, Category.JAPANESE);
        Assertions.assertThat(randomMenu).isNotEqualTo("규동");
        Assertions.assertThat(randomMenu).isNotEqualTo("우동");
        Assertions.assertThat(randomMenu).isNotEqualTo("미소시루");
    }

    @DisplayName("존재하지 않는 메뉴인 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"없는","메뉴"})
    void notExistMenu(String value) {
        Assertions.assertThatThrownBy(() -> Menu.validateMenu(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 메뉴인 경우 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"김밥","김치찌개", "나시고렝", "파인애플 볶음밥"})
    void existMenu(String value) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Menu.validateMenu(value);
        });
    }
}