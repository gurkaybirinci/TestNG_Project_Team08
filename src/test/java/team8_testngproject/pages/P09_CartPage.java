package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P09_CartPage {
    public P09_CartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
