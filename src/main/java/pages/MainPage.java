package pages;

public class MainPage {
	



public static String xpath_commonText(String Textvalue) {
	final String commonButtonmeth = "//div[text()='"+Textvalue+"']";
	return commonButtonmeth;
}

public static String xpath_prize(String prize) {
	final String commonButtonmeth = "//div[@class='"+prize+"']";
	return commonButtonmeth;
}

public static String xpath_LinkById() {
	final String commonButtonmeth = "//div[@id=\"shopping_cart_container\"]";
	return commonButtonmeth;
}

}
