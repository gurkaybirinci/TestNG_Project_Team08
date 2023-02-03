package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P07_ShoppingPage {
    public P07_ShoppingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
