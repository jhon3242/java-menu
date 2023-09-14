package menu;

import menu.domain.coach.Coach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MenuTest {

	@ParameterizedTest
	@MethodSource("exceptionMenuAddSuccessProvider")
	void exceptionMenuAddSuccess(List<String> menus) {
		Coach coach = new Coach("coA");

		Assertions.assertThatNoException().isThrownBy(() -> {
			menus.forEach(coach::addExceptionMenu);
		});
	}

	static Stream<Arguments> exceptionMenuAddSuccessProvider() {
		return Stream.of(
				Arguments.of(List.of("")),
				Arguments.of(List.of("파인애플 볶음밥")),
				Arguments.of(List.of("비빔밥", "가츠동"))
		);
	}

	@ParameterizedTest
	@MethodSource("exceptionMenuAddFailProvider")
	void coachListFailTest(List<String> menus) {
		Coach coach = new Coach("coA");

		Assertions.assertThatThrownBy(() -> {
			menus.forEach(coach::addExceptionMenu);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> exceptionMenuAddFailProvider() {
		return Stream.of(
				Arguments.of(List.of("없는 메뉴")),
				Arguments.of(List.of("비,빔밥")),
				Arguments.of(List.of("파인애플 볶음밥", "비빔밥", "가츠동"))
		);
	}
}
