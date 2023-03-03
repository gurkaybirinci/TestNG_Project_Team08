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

public class TC01_AllAreasFilled {
    private final String testName = "US01 || TC01-Gecerli Veri Girme ";
    private final String description = "Username dahil butun alanlara valid veri girilmeli";
    private final String raporMesaji = "Kullanıcı başarılı bir şekilde kayıd olabilmiştir.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void successfuCustomerRegisterationl() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Faker faker = new Faker();

        P01_HomePage homePage = new P01_HomePage();
        homePage.userRegisterButton.click();
        RaporlamaUtil.extentTestInfo("Home page'den Register sayfasina gidildi.");

        P02_RegisterPage registerPage = new P02_RegisterPage();
        registerPage.userNameBox.sendKeys(faker.name().username());
        registerPage.e_mailBox.sendKeys(faker.internet().emailAddress());
        registerPage.userPasswordBox.sendKeys(ConfigReader.getProperty("generatedPassword"));
        registerPage.policyAgreementBox.click();
        registerPage.userSignUpButton.click();
        RaporlamaUtil.extentTestInfo("SignUp işlemi yapıldı.");

        RaporlamaUtil.extentTestInfo("Username dahil, butun alanlara veri girilebildigi kontrol edildi.");
        Assert.assertTrue(homePage.homePageLogo.isDisplayed());

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";

    }

}
