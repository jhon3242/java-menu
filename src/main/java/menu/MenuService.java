package menu;

public class MenuService {
	private final MenuRepository menuRepository;
	private final CategoryRepository categoryRepository;

	public MenuService(MenuRepository menuRepository, CategoryRepository categoryRepository) {
		this.menuRepository = menuRepository;
		this.categoryRepository = categoryRepository;
	}

	public String recommendMenu(Coach coach, Category category) {
		String randomMenu = menuRepository.getRandomMenuByCategory(category);
		if (coach.canEat(randomMenu)) {
			coach.addNewAteMenu(randomMenu);
			return randomMenu;
		}
		return recommendMenu(coach, category);
	}

	public void initRandomCategories() {
		while (categoryRepository.needMoreCategory()) {
			Category randomCategory = Category.getRandomCategory();
			if (categoryRepository.isValidCategory(randomCategory)) {
				categoryRepository.addCategoryToList(randomCategory);
			}
		}
	}
}
