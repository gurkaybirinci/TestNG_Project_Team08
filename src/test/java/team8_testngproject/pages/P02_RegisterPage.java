package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P02_RegisterPage {
    public P02_RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

