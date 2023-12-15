package menu;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Converter;
import menu.message.ViewMessage;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    public static void run() {
        OutputView.printMessage(ViewMessage.OUTPUT_START);
        Coaches coaches = initCoaches();
        coaches.addExceptionMenuToEach(MainController::initExceptionMenu);

        recommendMenu(coaches);

        printRecommendResult(coaches);
    }

    public static Coaches initCoaches() {
        try {
            String value = InputView.readString(ViewMessage.INPUT_COACHES);
            return Converter.stringToCoaches(value);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return initCoaches();
        }
    }

    public static List<String> initExceptionMenu(Coach coach) {
        try {
            String value = InputView.readCoachExceptionMenu(coach);
            return Converter.stringToMenuList(value);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return initExceptionMenu(coach);
        }
    }

    private static void recommendMenu(Coaches coaches) {
        while (coaches.needRecommend()) {
            Category randomCategory = Category.getRandomCategory();
            if (coaches.isAvailableCategory(randomCategory)) {
                coaches.recommendMenu(randomCategory);
            }
        }
    }

    private static void printRecommendResult(Coaches coaches) {
        OutputView.printMessage(ViewMessage.OUTPUT_RESULT_PRE_MESSAGE);
        OutputView.printDayOfWeek();
        OutputView.printCategory(coaches);
        OutputView.printRecommendMenu(coaches);
        OutputView.printMessage(ViewMessage.OUTPUT_END);
    }
}
