package enums;

public enum Categories {
	ART(0), COMICS(1), CRAFT(2), DANCE(3), DESIGN(4), FASHION(5), VIDEOS(6), FOOD(7), GAMES(8), JOURNALISM(9), MUSIC(10), PHOTOGRAPHY(11), PUBLISHING(12), TECHNOLOGY(13), THEATER(14);
	
	public int categoriesIndex;

	private Categories(int categoriesIndex) {
		this.categoriesIndex = categoriesIndex;
	}
	
	public static Categories getCategory(int value)
	{
		switch (value) {
		case 1:
			return Categories.ART;
		case 2:
			return Categories.COMICS;
		case 3:
			return Categories.CRAFT;
		case 4:
			return Categories.DANCE;
		case 5:
			return Categories.DESIGN;
		case 6:
			return Categories.FASHION;
		case 7:
			return Categories.VIDEOS;
		case 8:
			return Categories.FOOD;
		case 9:
			return Categories.GAMES;
		case 10:
			return Categories.JOURNALISM;
		case 11:
			return Categories.MUSIC;
		case 12:
			return Categories.PHOTOGRAPHY;
		case 13:
			return Categories.PUBLISHING;
		case 14:
			return Categories.TECHNOLOGY;
		default:
			return Categories.THEATER;		
			}
	}
}
