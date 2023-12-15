package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.Category;
import menu.Coaches;
import menu.message.ExceptionMessage;
import menu.message.ViewMessage;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printException(IllegalArgumentException exception) {
        System.out.println(ViewMessage.ERROR_PREFIX + exception.getMessage());
    }

    public static void printDayOfWeek() {
        printList(List.of("구분", "월요일", "화요일", "수요일", "목요일", "금요일"));
    }

    public static void printCategory(Coaches coaches) {
        List<String> categoryView = new ArrayList<>(List.of("카테고리"));
        List<String> categoryies = coaches.getRecommendCategories().stream()
                .map(Category::getName)
                .collect(Collectors.toList());
        categoryView.addAll(categoryies);
        OutputView.printList(categoryView);
    }

    public static void printList(List<String> list) {
        String join = String.join(ViewMessage.OUTPUT_RESULT_DELIMITER, list);
        System.out.printf(ViewMessage.OUTPUT_RESULT_FORMAT, join);
    }

    public static void printRecommendMenu(Coaches coaches) {
        coaches.getCoaches()
                .forEach(coach -> {
                    List<String> recommendMenu = new ArrayList<>(List.of(coach.getName()));
                    recommendMenu.addAll(coach.getRecommendMenus());
                    OutputView.printList(recommendMenu);
                });
        System.out.println();
    }
}
