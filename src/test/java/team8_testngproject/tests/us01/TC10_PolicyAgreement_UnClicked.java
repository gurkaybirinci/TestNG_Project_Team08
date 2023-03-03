package team8_testngproject.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P02_RegisterPage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;
import team8_testngproject.utilities.ReusableMethods;

public class TC10_PolicyAgreement_UnClicked {
    private final String testName = "US01 || TC10-Policy Agreement Onaylanmadiginda ";
    private final String description = "policy agreement kutusuna tiklamadan kayid olunamamali";
    private final String raporMesaji = "Kullanıcı kayıd işlemini gerçekleştirememeli ve uyari mesaji almalı";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void RegistrationUnsuccessful_NameUnspecified() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker = new Faker();
        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        RaporlamaUtil.extentTestInfo("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(faker.name().username());
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys(faker.internet().password());
        registerPage.userSignUpButton.click();
        RaporlamaUtil.extentTestInfo("Kullanıcı kayıd işlemini gerçekleştiremedi ve uyari mesaji alir");

        Assert.assertTrue(registerPage.userRegisterPage.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}