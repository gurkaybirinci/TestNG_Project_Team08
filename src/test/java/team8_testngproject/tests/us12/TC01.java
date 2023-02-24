package team8_testngproject.tests.us12;

import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P05_AddressesPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC01 {
    @Test
    public void tc01(){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage = new P01_HomePage();
        homePage.signInButtonAli.click();

        P03_LoginPage loginPage= new P03_LoginPage();
        loginPage.usernameAli.sendKeys(ConfigReader.getProperty("vendorUserNameAli"));

        loginPage.passwordAli.sendKeys(ConfigReader.getProperty("vendorPasswordAli"));

        loginPage.loginAli.click();

        homePage.signOutButtonAli.click();

        P04_MyAccountPage myAccountPage= new P04_MyAccountPage();
        myAccountPage.addAddressesLinkAli.click();

        P05_AddressesPage addressesPage = new P05_AddressesPage();
        addressesPage.editlinkAli.click();


    }

}
