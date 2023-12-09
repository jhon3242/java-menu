package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public enum Category {
	JAPANESE("일식", 1),
	CHINESE("중식", 2),
	KOREAN("중식", 3),
	ASIAN("아시안", 4),
	WESTERN("양식", 5),
	;

	private final String name;
	private final int index;

	Category(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public static Category getRandomCategory() {
		int pickIndex = Randoms.pickNumberInRange(1, 5);
		return Arrays.stream(Category.values())
				.filter(category -> category.index == pickIndex)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("메뉴가 없습니다."));
	}

}
