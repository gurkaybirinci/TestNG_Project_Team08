package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P08_ProductPage {
    public P08_ProductPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
