package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {

	@RepeatedTest(10)
	void recommendMenu() {
		MenuService menuService = new MenuService(MenuRepository.init());
		Coach coach = new Coach("토미", List.of("우동", "스시"), new ArrayList<>());
		String result = menuService.recommendMenu(coach, Category.JAPANESE);

		System.out.println(result);
		Assertions.assertThat(result).isNotEqualTo("우동");
		Assertions.assertThat(result).isNotEqualTo("스시");
	}
}