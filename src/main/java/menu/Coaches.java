package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import menu.message.ExceptionMessage;

public class Coaches {
    public static final int MIN_SIZE = 2;
    public static final int MAX_SIZE = 5;
    public static final int MAX_RECOMMEND_COUNT = 5;
    public static final int MAX_SAME_CATEGORY_COUNT = 2;
    private final List<Coach> coaches;
    private final List<Category> recommendCategories;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
        this.recommendCategories = new ArrayList<>();
    }

    private void validate(List<Coach> coaches) {
        if (coaches == null || coaches.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
        if (coaches.size() < MIN_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.COACHE_MIN_SIZE);
        }
        if (coaches.size() > MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.COACHE_MAX_SIZE);
        }
    }

    public <T, R> void addExceptionMenuToEach(Function<T, R> method) {
        coaches.forEach(coach -> {
            R result = method.apply((T) coach);
            List<String> menus = (List<String>) result;
            coach.clearExceptionMenus(); // 이전 단계에서 에러가 발생했을수도 있어서 초기화
            menus.forEach(coach::addExceptionMenu);
        });
    }

    @Override
    public String toString() {
        return "Coaches{" +
                "coaches=" + coaches +
                '}';
    }

    public boolean needRecommend() {
        return recommendCategories.size() < MAX_RECOMMEND_COUNT;
    }

    public boolean isAvailableCategory(Category randomCategory) {
        int sameCount = (int) recommendCategories.stream()
                .filter(category -> category.equals(randomCategory))
                .count();
        return sameCount < MAX_SAME_CATEGORY_COUNT;
    }

    public void recommendMenu(Category randomCategory) {
        recommendCategories.add(randomCategory);
        coaches.forEach(coach -> {
            String randomMenu = Menu.getValidRandomMenu(coach, randomCategory);
            coach.addAteMenu(randomMenu);
        });
    }
}
