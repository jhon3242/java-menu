package menu;

import java.util.ArrayList;
import java.util.List;
import menu.message.ExceptionMessage;

public class Coach {
    public static final int EXCEPTION_MENU_MAX_SIZE = 2;
    private final String name;
    private final List<String> exceptionMenus;
    private final List<String> recommendMenus;

    public Coach(String name) {
        validate(name);
        this.name = name;
        this.exceptionMenus = new ArrayList<>();
        this.recommendMenus = new ArrayList<>();
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ExceptionMessage.COACH_NAME_LENGTH);
        }
    }

    // TODO 이전에 존재하는 메뉴인지 검증 필요
    public void addExceptionMenu(String menu) {
        if (exceptionMenus.size() > EXCEPTION_MENU_MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_MENU_MAX_SIZE);
        }
        exceptionMenus.add(menu);
    }

    // TODO 이전에 존재하는 메뉴인지 검증 필요
    public void addAteMenu(String menu) {
        recommendMenus.add(menu);
    }

    public boolean canEat(String menu) {
        return !exceptionMenus.contains(menu) &&
                !recommendMenus.contains(menu);
    }

    public void clearExceptionMenus() {
        exceptionMenus.clear();
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", exceptionMenus=" + exceptionMenus +
                ", ateMenus=" + recommendMenus +
                '}';
    }
}
