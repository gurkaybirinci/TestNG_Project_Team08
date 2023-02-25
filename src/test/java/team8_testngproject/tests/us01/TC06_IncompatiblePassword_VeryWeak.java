package team8_testngproject.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

import static team8_testngproject.utilities.ReusableMethods.waitFor;

public class TC06_IncompatiblePassword_VeryWeak {

    @Test
    public void UnsuccessfulRegistration_veryWeakPassword() {
        Driver.getDriver().get("https://hubcomfy.com/my-account-2/");
       Faker faker = new Faker();

       P01_HomePage homePage = new P01_HomePage();
       ReusableMethods.jsClick(homePage.myAccountButton);

        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        myAccountPage.myAccountSiginUpOnPopup.click();
        myAccountPage.myAccountUserNameReg.sendKeys(faker.name().username());
        myAccountPage.myAccountUserEmailReg.sendKeys(faker.internet().emailAddress());
       myAccountPage.myAccountPasswordReg.sendKeys(ConfigReader.getProperty("generatedPassword2"));

        Assert.assertTrue(myAccountPage.notification_VeryWeak.isDisplayed());

        waitFor(3);
        Driver.closeDriver();


    }




}
