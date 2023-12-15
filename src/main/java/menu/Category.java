package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import menu.message.ExceptionMessage;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private String name;
    private int index;

    Category(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static Category getRandomCategory() {
        int pick = Randoms.pickNumberInRange(1, 5);
        return Arrays.stream(Category.values())
                .filter(category -> category.index == pick)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.CATEGORY_NOT_EXIST));
    }

    public String getName() {
        return name;
    }
}
