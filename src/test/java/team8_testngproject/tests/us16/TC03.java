package team8_testngproject.tests.us16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC03 {
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_MyAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;
    @Test
    public void US16_TC03(){
        p01_homePage=new P01_HomePage();
        p03_loginPage=new P03_LoginPage();
        p04_MyAccountPage=new P04_MyAccountPage();
        p16VendorStoreManagerPage=new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage=new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage=new P18_VendorProductManagerPage();
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonKoz.click();
        p03_loginPage.usernameKoz.sendKeys("mehmetkozak46@gmail.com", Keys.TAB,"Koz.ak46");
        p03_loginPage.signInButtonKoz.click();
        p01_homePage.signOutButtonKoz.click();
        assert p04_MyAccountPage.myAccountTextKoz.isDisplayed();
        p16VendorStoreManagerPage.storeManagerButtonKoz.click();
        assert p16VendorStoreManagerPage.storeManagerTextKoz.isDisplayed();
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonKoz);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonKoz);
        assert p18_vendorProductManagerPage.addProductTextKoz.isDisplayed();
        p18_vendorProductManagerPage.priceInputKoz.sendKeys("12.75");
        Assert.assertEquals(p18_vendorProductManagerPage.priceInputKoz.getAttribute("type"),"number");
        p18_vendorProductManagerPage.salePriceInputKoz.sendKeys("20");
        Assert.assertEquals(p18_vendorProductManagerPage.salePriceInputKoz.getAttribute("type"),"number");


    }
}
