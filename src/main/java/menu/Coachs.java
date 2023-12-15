package menu;

import java.util.List;
import menu.message.ExceptionMessage;

public class Coachs {
    public static final int MIN_SIZE = 2;
    public static final int MAX_SIZE = 5;
    private final List<Coachs> coachs;

    public Coachs(List<Coachs> coachs) {
        validate(coachs);
        this.coachs = coachs;
    }

    private void validate(List<Coachs> coachs) {
        if (coachs == null || coachs.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
        if (coachs.size() < MIN_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.COACHE_MIN_SIZE);
        }
        if (coachs.size() > MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.COACHE_MAX_SIZE);
        }
    }
}
