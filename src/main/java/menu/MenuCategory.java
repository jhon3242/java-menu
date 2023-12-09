package menu;

public enum MenuCategory {
	JAPANESE("일식", 1),
	CHINESE("중식", 2),
	KOREAN("중식", 3),
	ASIAN("아시안", 4),
	WESTERN("양식", 5),
	;

	private final String name;
	private final int index;

	MenuCategory(String name, int index) {
		this.name = name;
		this.index = index;
	}



}
