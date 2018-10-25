package expertqa.october5_2018.mavrental;

public class ValidateMavData {
	
	private static final String ZIP_CODE_REGEX = "^\\d{5}(?:[-\\s]\\d{4})?$";
	private static final String RATE_REGEX = "[0-9] {1,}\\.[0-9] {2}";
	private static final String CREDIT_CARD_REGEX = "[0-9]{4}\\-[0-9]{4}\\-[0-9]{4}\\-[0-9]{4}";
	private static final String DAYS_REGEX = "[0-9] {1,}";
	
	public boolean checkCustomerZipCode(String zipCode) {
		return zipCode.matches(ZIP_CODE_REGEX);
	}

	public boolean checkCustomerCreditCard(String creditCardNumber) {
		if(creditCardNumber.matches(CREDIT_CARD_REGEX)) {
			char firstCharacter = creditCardNumber.charAt(0);
			if(firstCharacter < 52 || firstCharacter > 54) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean rentalrate(int rentalRate) {
		return String.valueOf(rentalRate).matches(RATE_REGEX);
	}

	public boolean checkRentalDays(int days) {
		return String.valueOf(days).matches(DAYS_REGEX);
	}
	
}
