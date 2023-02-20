package team8_testngproject.tests.us11;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P06_AccountDetailes;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC01 {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));


        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("vendorUserNameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("vendorPasswordEs"));
        p03_loginPage.signInButon_Es.click();
        p01_homePage.signOut_Es.click();


        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        Assert.assertEquals(p04_myAccountPage.myAccountSayfasi_Es.getText(),"My Account");

 //       Assert.assertEquals(p04_myAccountPage.ordersVendor_Es.getText(), "Orders");
//        Assert.assertEquals(p04_myAccountPage.downloadsVendor_Es.getText(), "Downloads");
//        Assert.assertEquals(p04_myAccountPage.adressesVendor_Es.getText(), "addresses");
//        Assert.assertEquals(p04_myAccountPage.accountDetailsVendor_Es.getText(),"account details");
//        Assert.assertEquals(p04_myAccountPage.wishlistVendor_Es.getText(),"whislist ");
//        Assert.assertEquals(p04_myAccountPage.logoutVendor_Es.getText(),"Logout ");






    }
}
