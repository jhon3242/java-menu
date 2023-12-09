package menu;

import java.util.List;

public class CategoryRepository {
	private final List<Category> categories;

	public CategoryRepository(List<Category> categories) {
		this.categories = categories;
	}

	public boolean needMoreCategory() {
		return categories.size() < 5;
	}

	public void addCategoryToList(Category pickedCategory) {
		if (isValidCategory(pickedCategory)) {
			categories.add(pickedCategory);
			return;
		}
		throw new IllegalArgumentException("더이상 추가할 수 없는 카테고리입니다.");
	}

	public boolean isValidCategory(Category pickedCategory) {
		int sameCount = (int) categories.stream()
				.filter(category -> category.equals(pickedCategory))
				.count();
		return sameCount < 2;
	}

	@Override
	public String toString() {
		return "CategoryRepository{" +
				"categories=" + categories +
				'}';
	}
}
