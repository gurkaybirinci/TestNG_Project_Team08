package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P01_HomePage {
    public P01_HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
