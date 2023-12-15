package menu;

import java.util.List;
import menu.message.ExceptionMessage;

public class Coaches {
    public static final int MIN_SIZE = 2;
    public static final int MAX_SIZE = 5;
    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
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

    @Override
    public String toString() {
        return "Coaches{" +
                "coaches=" + coaches +
                '}';
    }
}
