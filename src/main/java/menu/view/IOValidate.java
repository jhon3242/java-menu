package menu.view;

import menu.ExceptionMessage;

public class IOValidate {

	public static void validateString(String value) {
		isBlank(value);
	}

	private static void isBlank(String value) {
		if (value.isBlank()) {
			throw new IllegalStateException(ExceptionMessage.BLANK.getMessage());
		}
	}
}
