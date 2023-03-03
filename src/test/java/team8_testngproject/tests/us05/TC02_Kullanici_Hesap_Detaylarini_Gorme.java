package team8_testngproject.tests.us05;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.pages.P03_LoginPage;
import team8_testngproject.pages.P04_MyAccountPage;
import team8_testngproject.pages.P06_AccountDetailes;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.RaporlamaUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TC02_Kullanici_Hesap_Detaylarini_Gorme {
    private final String testName = "US05 || TC02 Kullanıcı hesap detaylarını görme ";
    private final String description = "First name, Last name, Display name ve Email address bilgilerini değiştirebilmeli";
    private final String raporMesaji = "Kullanıcının hesap detayları değiştirdiği doğrulanmıştır.";

    @Test(testName = testName, description = "<span style='font-weight:bold'>Amaç:</span> " + description)
    public void tc01() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        P01_HomePage p01_homePage = new P01_HomePage();
        p01_homePage.signIn_Es.click();

        P03_LoginPage p03_loginPage = new P03_LoginPage();
        p03_loginPage.userName_Es.sendKeys(ConfigReader.getProperty("usernameEs"));
        p03_loginPage.password_Es.sendKeys(ConfigReader.getProperty("passwordEs"));
        p03_loginPage.signInButon_Es.click();
        RaporlamaUtil.extentTestInfo("Login işlemi yapıldı.");

        p01_homePage.signOut_Es.click();
        Faker faker = new Faker();

        P04_MyAccountPage p04_myAccountPage = new P04_MyAccountPage();
        p04_myAccountPage.accountDetails_Es.click();

        P06_AccountDetailes p06_accountDetailes = new P06_AccountDetailes();
        p06_accountDetailes.firstName_Es.clear();
        p06_accountDetailes.firstName_Es.sendKeys(faker.name().firstName());
        p06_accountDetailes.lastName_Es.clear();
        p06_accountDetailes.lastName_Es.sendKeys(faker.name().lastName());
        p06_accountDetailes.displayName_Es.clear();
        p06_accountDetailes.displayName_Es.sendKeys(faker.name().username());

        RaporlamaUtil.extentTestInfo("Yeni first name, last name, display name verileri girildi ");

        // Aşağıdaki kod configuration.properties dosyasının içeriğini okur
        FileInputStream file = new FileInputStream("configuration.properties");
        Properties prop = new Properties();
        prop.load(file);
        file.close();

        // configuration.properties dosyasının içeriğindeki userNameEs değişkeninin değerini değiştirmeyi sağlar
        String newEmail = faker.internet().emailAddress();
        FileOutputStream output = new FileOutputStream("configuration.properties");
        prop.setProperty("usernameEs", newEmail);
        prop.store(output, null);
        output.close();

        p06_accountDetailes.emailAdress_Es.clear();
        p06_accountDetailes.emailAdress_Es.sendKeys(newEmail,
                Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB,
                Keys.TAB, Keys.TAB, Keys.ENTER);
        RaporlamaUtil.extentTestInfo("Kullanıcı bilgilerinin değiştiği görüldü");
        Assert.assertEquals(p06_accountDetailes.saveSuccessYazisi_Es.getText(), "Account details changed successfully.");
        Driver.closeDriver();

        RaporlamaUtil.message = "<span style='color:green; font-weight:bold; font-size: 14px'>TEST SONUCU: </span><br><span style='color:purple; font-size: 16px'>" + raporMesaji + "</span>";
    }
}
