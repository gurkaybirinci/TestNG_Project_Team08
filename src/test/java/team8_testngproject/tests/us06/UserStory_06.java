package team8_testngproject.tests.us06;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.ConfigReader;
import team8_testngproject.utilities.Driver;

public class UserStory_06 {
    P01_HomePage homePage;
    P07_ShoppingPage shoppingPage;
    P03_LoginPage loginPage;
    P08_ProductPage productPage;
    P09_CartPage cartPage;
    P10_CheckOutPage checkOutPage;

    @BeforeMethod
    public void beforeMethod() {
         homePage = new P01_HomePage();
         shoppingPage = new P07_ShoppingPage();
         loginPage = new P03_LoginPage();
         productPage = new P08_ProductPage();
         cartPage = new P09_CartPage();
         checkOutPage = new P10_CheckOutPage();
    }


    @Test
    public void us06_Tc01() {

        //Belirtilen URL'e gidilir.
        //Sign in butonuna tiklanir.
        //Email yada username bilgileri girilir.
        //Password bilgileri girilir.
        //Sign in butonuna tiklanir.
        loginPage.login();

        //Search cubuguna tiklanir.Arama yapilmak istenen urunun ismi girilir.
        //Arama butonuna tiklanir.
        homePage.searchProduct();

        //Istenen urune ait arama yapildigi dogrulanir.
        String resultText=shoppingPage.resultTextLoc.getText();

        Assert.assertTrue(resultText.contains(ConfigReader.getProperty("urun_ismi_mustafa")));

    }

    @Test
    public void us06_Tc02() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir.
        shoppingPage.firstProductLoc.click();

        //ADD TO CART butonunun tiklanir.
        productPage.addToCartBtnLoc.click();

        //Popup mesajının görüntülendigi dogrulanir.
        Assert.assertTrue(productPage.popupViewCartLoc.isDisplayed());
    }

    @Test
    public void us06_Tc03() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //Sepete eklenen urunlerin goruntulendigi dogrulanir.
        Assert.assertTrue(cartPage.productDisplayLoc.isDisplayed());
    }

    @Test
    public void us06_Tc04() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //Quantity alaninda urun miktari artirilir.
        //UPDATE CART butonuna tiklanir ve artis yapildigi dogrulanir.
        cartPage.checkPlusUpdate();

        //Quantity alaninda urun miktari azaltilir.
        //UPDATE CART butonuna tiklanir ve azaltma yapildigi dogrulanir.
        cartPage.checkMinusUpdate();
    }

    @Test
    public void us06_Tc05() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //BILLING DETAILS bolumunde zorunlu alanlar bos bırakilir.
        checkOutPage.firstNameInputClear();

        //PLACE ORDER butonu tiklanir.
        checkOutPage.goToPlaceOrder();

        //Popup - uyari mesaji goruntulendigi dogrulanir.
        Assert.assertTrue(checkOutPage.placeOrderPopupMessages.isDisplayed());
    }

    @Test
    public void us06_Tc06() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //Payment Methods bolumunde 2 ödeme seceneginin oldugu dogrulanir.
        Assert.assertTrue(checkOutPage.wireTransferEFTBtnLoc.isDisplayed());
        Assert.assertTrue(checkOutPage.payAtTheDoorBtnLoc.isDisplayed());

        //Pay at the door secenegi secilir.
        checkOutPage.selectPayAtTheDoor();

        //Pay at the door seceneginin secilebildigi dogrulanir
        Assert.assertTrue(checkOutPage.payAtTheDoorBtnLoc.isSelected());

        //Wire transfer/EFT secenegi secillir.
        checkOutPage.selectWireTransferEft();

        //Wire transfer/EFT seceneginin secilebildigi dogrulanir.
        Assert.assertTrue(checkOutPage.wireTransferEFTBtnLoc.isSelected());
    }

    @Test
    public void us06_Tc07() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //First name * inputu doldurulur.
        //Last name * inputu doldurulur.
        //Country / Region * dropdown'undan secim yapilir.
        //Street address * inputu doldurulur.
        //Postcode / ZIP * inputu doldurulur.
        //Town / City * inputu doldurulur.
        //Province * dropdown'undan secim yapilir.
        //Phone * inputu doldurulur.
        //Email address * inputu doldurulur.
        //Odeme seceneklerinden secim yapilir.
        //PLACE ORDER butonu tılklanir.
        //"Thank you. Your order has been received." mesaji goruntulendigi dogrulanir.
    }

    @AfterMethod
    public void afterTest(){
        Driver.closeDriver();
    }

}