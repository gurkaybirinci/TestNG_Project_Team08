package team8_testngproject.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC06_IncompatiblePassword_VeryWeak {

    @Test
    public void UnsuccessfulRegistration_veryWeakPassword() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
//        Faker faker = new Faker();
        P01_HomePage homePage = new P01_HomePage();
       ReusableMethods.jsClick(homePage.myAccountButton);
        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        myAccountPage.myAccountRegistrationBtn.click();
        myAccountPage.myAccountUserNameReg.sendKeys(ConfigReader.getProperty("generatedMyAccountUsername"));
        myAccountPage.myAccountUserEmailReg.sendKeys(ConfigReader.getProperty("generatedMyAccount"));
       myAccountPage.myAccountPasswordReg.sendKeys(ConfigReader.getProperty("generatedPassword2"));
        myAccountPage.myAccountPolicyCheckReg.click();
        myAccountPage.myAccountSginUpReg.click();

        // Assert.assertTrue(registerPage.notification_VeryWeak.isDisplayed());
        Assert.assertFalse(homePage.homePageLogo.isDisplayed());

    }




}
