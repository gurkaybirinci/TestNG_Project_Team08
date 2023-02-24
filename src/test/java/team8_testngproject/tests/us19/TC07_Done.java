package team8_testngproject.tests.us19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC07_Done {

    P01_HomePage p01HomePage;
    P03_LoginPage p03LoginPage;
    P04_MyAccountPage p04MyAccountPage;
    P19_OrdersPage p19OrdersPage;
    P07_ShoppingPage p07ShoppingPage;
    P08_ProductPage p08ProductPage;
    P10_CheckOutPage p10CheckOutPage;
    P15_VendorAddressesPage p15VendorAddressesPage;

    @Test
    public void us19_tc07() {

        p01HomePage = new P01_HomePage();
        p03LoginPage = new P03_LoginPage();
        p04MyAccountPage = new P04_MyAccountPage();
        p19OrdersPage = new P19_OrdersPage();
        p07ShoppingPage = new P07_ShoppingPage();
        p08ProductPage = new P08_ProductPage();
        p10CheckOutPage = new P10_CheckOutPage();
        p15VendorAddressesPage = new P15_VendorAddressesPage();

        //Url'ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Sign In butonuna tıklanır
        p01HomePage.registerButton_Nt.click();

        //Vendor hesapla login işlemi yapılır
        p03LoginPage.emailBox_Nt.sendKeys(ConfigReader.getProperty("vendorMail_Nt"));
        p03LoginPage.passwordBox_Nt.sendKeys(ConfigReader.getProperty("vendorPassword_Nt"));
        p03LoginPage.signInButton_Nt.click();

        //Sign Out butonuna tıklanır
        p01HomePage.signOutButton_Nt.click();

        //My Account sayfasının görünür olduğu doğrulanmalıdır
        ReusableMethods.verifyElementDisplayed(p04MyAccountPage.myAccountPage_Nt);

        //Orders linkine tıklanır
        p04MyAccountPage.ordersLink_Nt.click();

        //Orders sayfasınanın görünür olduğu doğrulanmalıdır
        Assert.assertTrue(p04MyAccountPage.ordersPageDisplayed_Nt.isDisplayed());

        //View butonu tıklanır
        p04MyAccountPage.viewButton_Nt.click();

        //Order Details yazısının görünür olduğu doğrulanmalıdır
        ReusableMethods.verifyElementDisplayed(p04MyAccountPage.orderDetailsDisplayed_Nt);

        Driver.closeDriver();


    }
}
