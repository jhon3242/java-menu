package menu.view;

public class IOValidate {

	public static void validateString(String value) {
		isBlank(value);
	}

	private static void isBlank(String value) {
		if (value.isBlank()) {
			throw new IllegalStateException("빈 값을 입력할 수 없습니다.");
		}
	}
}
