package pages;

public class LoginPage {
	
	public static String xpath_commonInputById(String value) {
		final String commonButtonmeth = "//input[@id='"+value+"']";
		return commonButtonmeth;
	}

}
