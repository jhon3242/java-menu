package menu;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> exceptionMenus;
    private final List<String> ateMenus;

    public Coach(String name) {
        this.name = name;
        this.exceptionMenus = new ArrayList<>();
        this.ateMenus = new ArrayList<>();
    }

    // TODO 이전에 존재하는 메뉴인지 검증 필요
    public void addExceptionMenu(String menu) {
        exceptionMenus.add(menu);
    }

    // TODO 이전에 존재하는 메뉴인지 검증 필요
    public void addAteMenu(String menu) {
        ateMenus.add(menu);
    }

    public boolean canEat(String menu) {
        return !exceptionMenus.contains(menu) &&
                !ateMenus.contains(menu);
    }
}
