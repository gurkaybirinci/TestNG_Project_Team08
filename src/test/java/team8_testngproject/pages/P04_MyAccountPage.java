package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P04_MyAccountPage {
    public P04_MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
