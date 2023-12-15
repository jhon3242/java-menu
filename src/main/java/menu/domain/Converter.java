package menu.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private static final String REGEX = ",";

    public static Coaches stringToCoaches(String value) {
        List<Coach> coaches = Arrays.stream(value.split(REGEX))
                .map(Converter::stringToCoach)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }

    public static Coach stringToCoach(String value) {
        return new Coach(value);
    }

    public static List<String> stringToMenuList(String value) {
        List<String> menus = Arrays.stream(value.split(REGEX))
                .collect(Collectors.toList());
        menus.forEach(Menu::validateMenu);
        return menus;
    }
}
