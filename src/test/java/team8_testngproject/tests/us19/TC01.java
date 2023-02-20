package team8_testngproject.tests.us19;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import team8_testngproject.pages.P01_HomePage;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;
import team8_testngproject.utilities.ReusableMethods;

public class TC01 {

    P01_HomePage p01HomePage;
    @Test
    public void test1(){

        p01HomePage=new P01_HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        p01HomePage.registerButton_Nt.click();
        Driver.getDriver().findElement(By.id("username")).sendKeys("rye.moaz@foundtoo.com");//username
        Driver.getDriver().findElement(By.id("password")).sendKeys("Hubcomfy123");          //password
        Driver.getDriver().findElement(By.xpath("//button[.='Sign In']")).click();        //sign in
        Driver.getDriver().findElement(By.xpath("//div[.='Sign Out']")).click();          //sign out

        ReusableMethods.verifyElementDisplayed(By.xpath("//h2[.='My Account']"));         //my account

        Driver.getDriver().findElement(By.linkText("Orders")).click();                                  //orders
        ReusableMethods.verifyElementDisplayed(By.xpath("//h2[.='My Account']"));         //
        ReusableMethods.verifyElementDisplayed(By.xpath("//a[.='Browse products']"));                         //
        Driver.getDriver().findElement(By.xpath("//a[.='Browse products']")).click();          //sign out
        ReusableMethods.verifyElementDisplayed(By.xpath("//li[.='Shop']"));                         //
        Driver.getDriver().findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("bilgisyar", Keys.ENTER);       //sign out


    }


}
