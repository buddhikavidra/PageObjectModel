package pages;

public class ItemPage {
	
	public static String xpath_commonButtonById(String value) {
		final String commonButtonmeth = "//button[@id='"+value+"']";
		return commonButtonmeth;
	}

}
