package team8_testngproject.tests.us16;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC02 {//Simple Product default olarak gelmeli
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_MyAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;


    @Test
    public void US16_TC01() {
        p01_homePage = new P01_HomePage();
        p03_loginPage = new P03_LoginPage();
        p04_MyAccountPage = new P04_MyAccountPage();
        p16VendorStoreManagerPage = new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage = new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage = new P18_VendorProductManagerPage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonHus.click();
        p03_loginPage.usernameHus.sendKeys("mehmetkozak46@gmail.com", Keys.TAB, "Koz.ak46");
        p03_loginPage.signInButtonHus.click();
        p01_homePage.signOutButtonHus.click();
        assert p04_MyAccountPage.myAccountTextHus.isDisplayed();
        p16VendorStoreManagerPage.storeManagerButtonHus.click();
        assert p16VendorStoreManagerPage.storeManagerTextHus.isDisplayed();
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonHus);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonHus);
        assert p18_vendorProductManagerPage.addProductTextHus.isDisplayed();
        p18_vendorProductManagerPage.downabledCheckboxHus.click();
        assert p18_vendorProductManagerPage.downabledCheckboxHus.isSelected();
        p18_vendorProductManagerPage.virtualCheckboxHus.click();
        assert p18_vendorProductManagerPage.virtualCheckboxHus.isSelected();

    }
}
