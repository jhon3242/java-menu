package menu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
}