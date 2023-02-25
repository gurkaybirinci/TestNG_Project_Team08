package team8_testngproject.tests.us17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC02 {
    P01_HomePage p01_homePage;
    P03_LoginPage p03_loginPage;
    P04_MyAccountPage p04_myAccountPage;
    P16_VendorStoreManagerPage p16VendorStoreManagerPage;
    P17_VendorProductsDashboardPage p17_vendorProductsDashboardPage;
    P18_VendorProductManagerPage p18_vendorProductManagerPage;
    @Test
    public void US17_TC02(){
        p01_homePage=new P01_HomePage();
        p03_loginPage=new P03_LoginPage();
        p04_myAccountPage=new P04_MyAccountPage();
        p16VendorStoreManagerPage=new P16_VendorStoreManagerPage();
        p17_vendorProductsDashboardPage=new P17_VendorProductsDashboardPage();
        p18_vendorProductManagerPage=new P18_VendorProductManagerPage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01_homePage.signInButtonKoz.click();
        p03_loginPage.usernameKoz.sendKeys("mehmetkozak46@gmail.com", Keys.TAB,"Koz.ak46");
        p03_loginPage.signInButtonKoz.click();
        p01_homePage.signOutButtonKoz.click();
        assert p04_myAccountPage.myAccountTextKoz.isDisplayed();
        p16VendorStoreManagerPage.storeManagerButtonKoz.click();
        assert p16VendorStoreManagerPage.storeManagerTextKoz.isDisplayed();
        ReusableMethods.jsClick(p16VendorStoreManagerPage.productsButtonKoz);
        ReusableMethods.jsClick(p17_vendorProductsDashboardPage.addNewButtonKoz);
        assert p18_vendorProductManagerPage.addProductTextKoz.isDisplayed();
        Select select=new Select(p18_vendorProductManagerPage.dropdownKoz);
        select.selectByVisibleText("Variable Product");
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.attributesButtonKoz);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.colorCheckBoxKoz);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.addNewColorButtonKoz);
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().sendKeys("Allah belamızı verdi sonunda!!!");
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        ReusableMethods.jsClick(p18_vendorProductManagerPage.sizeCheckBoxKoz);
        ReusableMethods.jsClick(p18_vendorProductManagerPage.addNewSizeButtonKoz);
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().sendKeys("Bir aşk kaç beden giyer?");
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();
        ReusableMethods.waitFor(2);
        Driver.driver.switchTo().alert().accept();

        Select select1=new Select(p18_vendorProductManagerPage.colorTextBoxKoz);
        select1.selectByVisibleText("Allah belamızı verdi sonunda!!!");
        Assert.assertEquals(select1.getAllSelectedOptions().get(0).getText(),p18_vendorProductManagerPage.eklenenYeniRenk.getText());
        Select select2=new Select(p18_vendorProductManagerPage.sizeTextBoxKoz);
        select2.selectByVisibleText("Bir aşk kaç beden giyer?");
        Assert.assertEquals(select2.getAllSelectedOptions().get(0).getText(),"Bir aşk kaç beden giyer?");

    }
}
