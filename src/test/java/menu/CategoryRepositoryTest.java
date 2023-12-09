package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRepositoryTest {

	@DisplayName("더이상 추가할 수 없는 카테고리인 경우 예외를 발생시킨다.")
	@Test
	void initRandomCategories() {
		CategoryRepository categoryRepository = new CategoryRepository(new ArrayList<>());
		categoryRepository.addCategoryToList(Category.KOREAN);
		categoryRepository.addCategoryToList(Category.KOREAN);

		Assertions.assertThatThrownBy(() -> categoryRepository.addCategoryToList(Category.KOREAN))
				.isInstanceOf(IllegalArgumentException.class);
	}
}