package menu;

import menu.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

class CategoryTest {

    @RepeatedTest(10)
    void getRandomCategory() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Category category = Category.getRandomCategory();
            System.out.println(category);
        });
    }
}