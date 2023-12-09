package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuServiceTest {
	private MenuService menuService;


	@BeforeEach()
	void setUp() {
		menuService = new MenuService(MenuRepository.init(), new CategoryRepository(new ArrayList<>()));
	}

	@DisplayName("카테고리에 맞는 메뉴를 추천한다.")
	@RepeatedTest(10)
	void recommendMenu() {
		Coach coach = new Coach("토미", List.of("우동", "스시"), new ArrayList<>());
		String result = menuService.recommendMenu(coach, Category.JAPANESE);

		System.out.println(result);
		Assertions.assertThat(result).isNotEqualTo("우동");
		Assertions.assertThat(result).isNotEqualTo("스시");
	}


	@DisplayName("이미 추천한 메뉴를 추천하지 않는다.")
	@RepeatedTest(10)
	void recommendMenuSameMenu() {
		Coach coach = new Coach("토미", List.of("우동", "스시"), new ArrayList<>());
		String randomMenu1 = menuService.recommendMenu(coach, Category.JAPANESE);
		String randomMenu2 = menuService.recommendMenu(coach, Category.JAPANESE);

		Assertions.assertThat(randomMenu1).isNotEqualTo(randomMenu2);
	}
}