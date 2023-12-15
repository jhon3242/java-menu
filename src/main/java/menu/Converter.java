package menu;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.message.ExceptionMessage;

public class Converter {

    public static final String COACH_REGEX = ",";

    public static Coaches stringToCoaches(String value) {
        validate(value);
        List<Coach> coaches = Arrays.stream(value.split(COACH_REGEX))
                .map(Converter::stringToCoach)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }

    private static void validate(String value) {
        String namePattern = "^[가-힣a-zA-Z]+(,[가-힣a-zA-Z]+)*$";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
    }

    public static Coach stringToCoach(String value) {
        return new Coach(value);
    }
}
