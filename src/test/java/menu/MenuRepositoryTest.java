package menu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MenuRepositoryTest {

	@ParameterizedTest
	@MethodSource("getRandomMenuByCategoryProvider")
	void getRandomMenuByCategory(MenuCategory category) {
		MenuRepository menuRepository = MenuRepository.init();
		String result = menuRepository.getRandomMenuByCategory(category);
		System.out.println(result);
	}

	static Stream<Arguments> getRandomMenuByCategoryProvider() {
		return Stream.of(
				Arguments.of(MenuCategory.JAPANESE),
				Arguments.of(MenuCategory.KOREAN),
				Arguments.of(MenuCategory.CHINESE),
				Arguments.of(MenuCategory.ASIAN),
				Arguments.of(MenuCategory.WESTERN)
		);
	}
}