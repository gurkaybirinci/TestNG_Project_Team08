package team8_testngproject.tests.us14;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

import java.util.List;

public class TC11_Categories_Ekleme { // Categories bölümüne yeni kategori eklenebilmeli (PASS)
    private final String testName = "US14 || TC11-Categories Ekleme";
    private final String description = "Categories bölümüne yeni kategori eklenebilmeli";
    private final String raporMesaji = "Categories bölümüne yeni kategori eklenebildiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01() {
        P01_HomePage homePage = new P01_HomePage();
        P03_LoginPage loginPage = new P03_LoginPage();
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        P16_VendorStoreManagerPage vendorStoreManagerPage = new P16_VendorStoreManagerPage();
        P18_VendorProductManagerPage vendorProductManagerPage = new P18_VendorProductManagerPage();
        Faker faker = new Faker();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        homePage.signInGur.click();
        loginPage.userNameGur.sendKeys(ConfigReader.getProperty("usernameGur"));
        loginPage.passwordGur.sendKeys(ConfigReader.getProperty("passwordGur"));
        loginPage.signInButtonGur.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        homePage.signOutGur.click();
        myAccountPage.storeManagerGur.click();
        ReusableMethods.hover(vendorStoreManagerPage.productButtonGur);
        vendorStoreManagerPage.productAddNewButtonGur.click();
        RaporlamaUtil.extentTestInfo("Product Manager sayfasına girildi.");

        String categoryName = faker.team().name();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addCategoryLinkGur);
        vendorProductManagerPage.categoryNameGur.sendKeys(categoryName);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", vendorProductManagerPage.addButtonGur);
        Driver.getDriver().navigate().refresh();
        RaporlamaUtil.extentTestInfo("Categories bölümüne yeni kategori eklenip eklenemediği kontrol edilmiştir.");

        List<WebElement> categoryList = vendorProductManagerPage.categoryListGur;
        boolean categoryNameVarMi = false;
        for (WebElement w : categoryList) {
            if (w.getText().equals(categoryName)) {
                categoryNameVarMi = true;
                break;
            }
        }
        Assert.assertTrue(categoryNameVarMi);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }
}
