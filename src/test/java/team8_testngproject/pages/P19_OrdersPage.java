package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P19_OrdersPage {
    public P19_OrdersPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
