package menu;

public class MenuService {
	private final MenuRepository menuRepository;

	public MenuService(MenuRepository repository) {
		menuRepository = repository;
	}

	public String recommendMenu(Coach coach, Category category) {
		String randomMenu = menuRepository.getRandomMenuByCategory(category);
		if (coach.canEat(randomMenu)) {
			coach.addNewAteMenu(randomMenu);
			return randomMenu;
		}
		return recommendMenu(coach, category);
	}
}
