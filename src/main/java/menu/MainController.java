package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.message.ViewMessage;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    public static void run() {
        OutputView.printMessage(ViewMessage.OUTPUT_START);

        // 코치 이름 초기화
        Coaches coaches = initCoaches();

        // 못먹는 메뉴 입력
        coaches.addExceptionMenuToEach(MainController::initExceptionMenu);

        // 추천 결과
        while (coaches.needRecommend()) {
            Category randomCategory = Category.getRandomCategory();
            if (coaches.isAvailableCategory(randomCategory)) {
                coaches.recommendMenu(randomCategory);
            }
        }
        OutputView.printMessage(ViewMessage.OUTPUT_RESULT_PRE_MESSAGE);
        OutputView.printDayOfWeek();
        OutputView.printCategory(coaches);
        OutputView.printRecommendMenu(coaches);
        OutputView.printMessage(ViewMessage.OUTPUT_END);
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
}
