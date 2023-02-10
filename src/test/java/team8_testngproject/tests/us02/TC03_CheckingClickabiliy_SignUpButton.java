package team8_testngproject.tests.us02;

import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class TC03_CheckingClickabiliy_SignUpButton {

    @Test
    public void SignUpWithAClick(){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        P01_HomePage homePage=new P01_HomePage();
        homePage.userRegisterButton.click();
        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(ConfigReader.getProperty("generatedUserName"));
        registerPage.e_mailBox.sendKeys(ConfigReader.getProperty("generatedUserEmail"));
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassWord"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();

        Assert.assertTrue(homePage.homePageLogo.isDisplayed());
    }





}
