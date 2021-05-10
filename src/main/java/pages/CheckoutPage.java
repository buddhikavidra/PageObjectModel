package pages;

public class CheckoutPage {
	
	
	public static String xpath_ItemCount() {
		final String xpath_ItemCount = "//div[@class=\"inventory_item_name\"]";
		return xpath_ItemCount;
	}

	public static String xpath_Header() {
		final String xpath_Header = "//h2[@class=\"complete-header\"]";
		return xpath_Header;
	}

}
