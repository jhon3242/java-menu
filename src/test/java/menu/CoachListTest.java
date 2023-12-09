package menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CoachListTest {

	@DisplayName("코치리스트 정상 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"토미,제임스,포코", "토미,제임스", "하나,둘이,셋이,넷이,다섯"})
	void initByStringSuccess(String input) {
		Assertions.assertThatNoException().isThrownBy(() -> {
			CoachList result = CoachList.initByString(input);
		});
	}

	@DisplayName("코치리스트 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"토미", " " ,"토미 제임스 포코", "토미,제임스,포코,길링,파랑,노랑"})
	void initByStringFail(String input) {
		Assertions.assertThatThrownBy(() -> CoachList.initByString(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}