package menu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MenuRepositoryTest {

	@ParameterizedTest
	@MethodSource("getRandomMenuByCategoryProvider")
	void getRandomMenuByCategory(Category category) {
		MenuRepository menuRepository = MenuRepository.init();
		String result = menuRepository.getRandomMenuByCategory(category);
		System.out.println(result);
	}

	static Stream<Arguments> getRandomMenuByCategoryProvider() {
		return Stream.of(
				Arguments.of(Category.JAPANESE),
				Arguments.of(Category.KOREAN),
				Arguments.of(Category.CHINESE),
				Arguments.of(Category.ASIAN),
				Arguments.of(Category.WESTERN)
		);
	}
}