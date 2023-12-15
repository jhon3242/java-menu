package menu;

import menu.message.ViewMessage;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    public static void run() {
        OutputView.printMessage(ViewMessage.OUTPUT_START);

        // 코치 이름 초기화
        Coaches coaches = initCoaches();

        // 못먹는 메뉴 입력

        // 추천 결과
    }

    public static Coaches initCoaches() {
        try {
            String value = InputView.readString(ViewMessage.INPUT_COACHS);
            return Converter.stringToCoaches(value);
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return initCoaches();
        }
    }
}
