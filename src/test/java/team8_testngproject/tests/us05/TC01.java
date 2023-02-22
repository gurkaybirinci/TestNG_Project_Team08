package team8_testngproject.tests.us05;

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
    public void tc01() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));


        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("usernameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p03_loginPage.signInButon_Es.click();

        p01_homePage.signOut_Es.click();


        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        p04_myAccountPage.accountDetails_Es.click();

        P06_AccountDetailes p06_accountDetailes = new P06_AccountDetailes();
        Assert.assertEquals(p06_accountDetailes.accountDetailsSayfasindamisin_Es.getText(), "Account Details");
        Assert.assertTrue(p06_accountDetailes.firstName_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.lastName_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.displayName_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.emailAdress_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.biography_Es.isDisplayed());
        Assert.assertTrue(p06_accountDetailes.passwordAlani1_Es.isDisplayed());



//        p06_accountDetailes.firstName_Es.sendKeys("ad1");
//        p06_accountDetailes.lastName_Es.sendKeys("soyad1");
//        p06_accountDetailes.displayName_Es.clear();
//        p06_accountDetailes.displayName_Es.sendKeys("yeniad1");
//        p06_accountDetailes.emailAdress_Es.clear();
//        p06_accountDetailes.emailAdress_Es.sendKeys("raeden.takeshi@foundtoo.com",
//                                                    Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,
//                                                    Keys.TAB,Keys.TAB,Keys.ENTER);


    }
}
