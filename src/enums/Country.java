package enums;

public enum Country {
	USA(0), UK(1), CANADA(2), AUSTRALIA(3), NEWZELAND(4), NETHERLANDS(5), DENMARK(6), IRELAND(7), NORWAY(8), SWEDEN(
			9), GERMANY(10), FRANCE(11), SPAIN(12), ITALY(
					13), AUSTRIA(14), BELGIUM(15), SWITZERLAND(16), HONGKONG(17), SINGAPORE(18), MEXICO(19), JAPAN(20);
	private int countryIndex;
	private Country(int countryIndex) {
		this.countryIndex = countryIndex;
	}
	
	public static Country getCountry(int value)
	{
		switch (value) {
		case 0:
			return Country.USA;
		case 1:
			return Country.UK;
		case 2:
			return Country.CANADA;
		case 3:
			return Country.AUSTRALIA;
		case 4:
			return Country.NEWZELAND;
		case 5:
			return Country.NETHERLANDS;
		case 6:
			return Country.DENMARK;
		case 7:
			return Country.IRELAND;
		case 8:
			return Country.NORWAY;
		case 9:
			return Country.SWEDEN;
		case 10:
			return Country.GERMANY;
		case 11:
			return Country.FRANCE;
		case 12:
			return Country.SPAIN;
		case 13:
			return Country.ITALY;
		case 14:
			return Country.AUSTRIA;
		case 15:
			return Country.BELGIUM;
		case 16:
			return Country.SWITZERLAND;
		case 17:
			return Country.HONGKONG;
		case 18:
			return Country.SINGAPORE;
		case 19:
			return Country.MEXICO;
		default:
			return Country.JAPAN;		
			}
	}
}
