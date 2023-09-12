package menu;

import menu.domain.Coach;
import menu.domain.CoachList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class CoachTest {

	@ParameterizedTest
	@ValueSource(strings = {"joj", "asdw", "sw", "mike", "file"})
	void coachSuccessTest(String name) {
		Assertions.assertThatNoException().isThrownBy(() -> {
			new Coach(name);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "", "asdfg", "anwldnaljkwfb", "a,s"})
	void coachFailTest(String name) {
		Assertions.assertThatThrownBy(() -> {
			new Coach(name);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@MethodSource("coachListSuccessProvider")
	void coachListSuccessTest(List<Coach> coachList) {
		Assertions.assertThatNoException().isThrownBy(() -> {
			new CoachList(coachList);
		});
	}

	static Stream<Arguments> coachListSuccessProvider() {
		return Stream.of(
				Arguments.of(List.of(new Coach("coA"), new Coach("coB"))),
				Arguments.of(List.of(new Coach("coA"), new Coach("coB"), new Coach("coC"))),
				Arguments.of(List.of(new Coach("coA"), new Coach("coB"), new Coach("coC"), new Coach("as"), new Coach("ab")))
		);
	}

	@ParameterizedTest
	@MethodSource("coachListFailProvider")
	void coachListFailTest(List<Coach> coachList) {
		Assertions.assertThatThrownBy(() -> {
			new CoachList(coachList);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	static Stream<Arguments> coachListFailProvider() {
		return Stream.of(
				Arguments.of(List.of(new Coach("wd"))),
				Arguments.of(List.of(new Coach("awd"), new Coach("as"), new Coach("ax"), new Coach("ad"), new Coach("ac"), new Coach("ab")))
		);
	}
}
