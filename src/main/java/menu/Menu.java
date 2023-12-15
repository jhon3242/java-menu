package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.message.ExceptionMessage;

public enum Menu {
    JAPANESE(Category.JAPANESE, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(Category.KOREAN, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(Category.CHINESE, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(Category.ASIAN, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(Category.WESTERN, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));


    private Category category;
    private List<String> menus;

    Menu(Category category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }

    public static String getRandomMenu(Coach coach, Category category) {
        Menu pick = findByCategory(category);
        List<String> pickMenus = new ArrayList<>(pick.menus);
        while (true) {
            pickMenus = Randoms.shuffle(pickMenus);
            String pickMenu = pickMenus.get(0);
            if (coach.canEat(pickMenu)) {
                return pickMenu;
            }
        }
    }

    private static Menu findByCategory(Category category) {
        return Arrays.stream(values())
                .filter(menu -> menu.category == category)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_CATEGORY));
    }

}
