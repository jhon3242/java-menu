package menu;

import menu.domain.Converter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {

    @DisplayName("코치 이름 문자열 변환에 대한 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"가나,다라,마바,사", "가나,     다라, 마바", "가나 다라 마바"})
    void coachesConverterFail(String value) {
        Assertions.assertThatThrownBy(() -> Converter.stringToCoaches(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코치 이름 문자열 변환에 대한 예외 발생하지 않는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"가나,다라,마바", "가나,다라"})
    void coachesConverterSuccess(String value) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Converter.stringToCoaches(value);
        });
    }

    @DisplayName("메뉴 문자열 변환에 대한 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"쌈밥,김치찌개,짜장만", "쌈밥,없는메뉴"})
    void exceptionMenuConverterFail(String value) {
        Assertions.assertThatThrownBy(() -> Converter.stringToMenuList(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 문자열 변환에 대한 예외 발생하지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"쌈밥", "파인애플 볶음밥,불고기", "쌈밥,팟타이"})
    void exceptionMenuConverterSuccess(String value) {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Converter.stringToMenuList(value);
        });
    }
}