package team8_testngproject.tests.us15;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class US15TC01_VendorOlarakAdvancedMenuleriGorebilmeli { //Vendor olarak, Inventory, Shipping, Attributes, Linked, Seo, Toptan Ürün Gösterme Ayarları, Advanced menüleri görülebilmeli (PASS)
    private final String testName = "US15 || TC01-Vendor olarak Advanced menüleri görülebilmeli";
    private final String description = "Vendor olarak, Inventory, Shipping, Attributes, Linked, Seo, Toptan Ürün Gösterme Ayarları, Advanced menüleri görülebilmeli";
    private final String raporMesaji = "Vendor olarak Advanced menüleri görülebildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void vendorOlarakAdvancedMenuleriGorebilmeli() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInRs.click();
        loginPage.userNameRs.sendKeys(ConfigReader.getProperty("usernameRs"));
        loginPage.passwordRs.sendKeys(ConfigReader.getProperty("passwordRs"));
        loginPage.signInButtonRs.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        homePage.signOutRs.click();
        myAccountPage.storeManagerRs.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonRs);
        vendorStoreManagerPage.productAddNewButtonRs.click();
        RaporlamaUtil.extentTestInfo("Add Product sayfasına gidildi.");

        Assert.assertTrue(vendorProductManagerPage.inventoryMenuRs.isDisplayed());
        Assert.assertTrue(vendorProductManagerPage.shippingMenuRs.isDisplayed());
        Assert.assertTrue(vendorProductManagerPage.attributesMenuRs.isDisplayed());
        Assert.assertTrue(vendorProductManagerPage.linkedMenuRs.isDisplayed());
        Assert.assertTrue(vendorProductManagerPage.seoMenuRs.isDisplayed());
        Assert.assertTrue(vendorProductManagerPage.toptanUrunGostAyrMenuRs.isDisplayed());
        Assert.assertTrue(vendorProductManagerPage.advancedMenuRs.isDisplayed());
        Driver.closeDriver();
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}

