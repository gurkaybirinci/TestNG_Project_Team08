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

public class TC07_IncompatiblePassword_Weak {

    @Test
    public void UnsuccessfulRegistration_weakPassword(){
        Driver.getDriver().get("https://hubcomfy.com/my-account-2/");
        Faker faker = new Faker();

        P01_HomePage homePage = new P01_HomePage();
        ReusableMethods.jsClick(homePage.myAccountButton);

        P04_MyAccountPage myAccountPage = new P04_MyAccountPage();
        myAccountPage.myAccountSiginUpOnPopup.click();
        myAccountPage.myAccountUserNameReg.sendKeys(faker.name().username());
        myAccountPage.myAccountUserEmailReg.sendKeys(faker.internet().emailAddress());
        myAccountPage.myAccountPasswordReg.sendKeys(ConfigReader.getProperty("generatedPassword3"));

        Assert.assertTrue(myAccountPage.notification_Weak.isDisplayed());

        waitFor(3);
        Driver.closeDriver();






    }
}
