package team8_testngproject.pages;

import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

public class P05_AddressesPage {
    public P05_AddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
