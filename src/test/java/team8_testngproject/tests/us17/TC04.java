package team8_testngproject.tests.us17;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC04 {
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_myAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;
    private final String testName = "US17 || TC04-Eklenen Attribute'ün Variations'ta Görünmesi";
    private final String description = "Attribute eklenebilmeli, Variations'a tıklanarak eklenen Atributes görülebilmelidir";
    private final String raporMesaji = "Eklenen Attribute'ün Variations'a tıklanarak görülebildiği doğrulanmıştır";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void US17_TC04() {
        p01_homePage = new P01_HomePage();
        p03_loginPage = new P03_LoginPage();
        p04_myAccountPage = new P04_MyAccountPage();
        p16VendorStoreManagerPage = new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage = new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage = new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonKoz.click();
        p03_loginPage.usernameKoz.sendKeys(ConfigReader.getProperty("usermailkoz"), Keys.TAB, ConfigReader.getProperty("passwordkoz"));
        p03_loginPage.signInButtonKoz.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");
        p01_homePage.signOutButtonKoz.click();
        assert p04_myAccountPage.myAccountTextKoz.isDisplayed();
        p16VendorStoreManagerPage.storeManagerButtonKoz.click();
        assert p16VendorStoreManagerPage.storeManagerTextKoz.isDisplayed();
        RaporlamaUtil.extentTestInfo("Store Manager sayfasına girildi.");
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonKoz);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonKoz);
        assert p18_vendorProductManagerPage.addProductTextKoz.isDisplayed();
        RaporlamaUtil.extentTestInfo("Ürün ekleme sayfasına girildi.");
        Select select = new Select(p18_vendorProductManagerPage.dropdownKoz);
        select.selectByVisibleText("Variable Product");
        RaporlamaUtil.extentTestInfo("Dropdown içerisinde Variable Products seçildi.");
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.attributesButtonKoz);
        ReusableMethods.waitFor(5);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.addAttributeButtonKoz);
        p18_vendorProductManagerPage.attributeNameKoz.sendKeys("Made in");
        p18_vendorProductManagerPage.attributeValueKoz.sendKeys("Turkey | Usa | China | Germany | Paraguay");
        ReusableMethods.jsClick(p18_vendorProductManagerPage.variatonsButtonKoz);
        Select select1 = new Select(p18_vendorProductManagerPage.defaultFormValuesKoz);
        Assert.assertTrue(select1.getFirstSelectedOption().getText().contains("Made in"));
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
