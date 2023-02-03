package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P03_LoginPage {
    public P03_LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
