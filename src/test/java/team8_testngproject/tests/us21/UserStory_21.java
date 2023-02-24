package team8_testngproject.tests.us21;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team8_testngproject.pages.*;
import team8_testngproject.utilities.Driver;

public class UserStory_21 {
    P01_HomePage homePage;
    P07_ShoppingPage shoppingPage;
    P03_LoginPage loginPage;
    P08_ProductPage productPage;
    P09_CartPage cartPage;
    P10_CheckOutPage checkOutPage;
    P11_OrderCompletePage orderCompletePage;

    @BeforeMethod
    public void beforeMethod() {
        homePage = new P01_HomePage();
        shoppingPage = new P07_ShoppingPage();
        loginPage = new P03_LoginPage();
        productPage = new P08_ProductPage();
        cartPage = new P09_CartPage();
        checkOutPage = new P10_CheckOutPage();
        orderCompletePage = new P11_OrderCompletePage();
    }


    @Test
    public void us21_Tc01() {

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
        shoppingPage.checkSearchProduct();
    }

    @Test
    public void us21_Tc02() {

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
    public void us21_Tc03() {

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
    public void us21_Tc04() {

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
    public void us21_Tc05() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //Enter coupon cod here... inputuna kupon kodu girilir.
        //APPLY COUPON butonu tiklanir
        productPage.useCouponCode();

        //Kupon ile urune indirim tanimlandigi dogrulanir.
        productPage.checkCouponCodeUse();

        //Tanımlanan kupon silinir ve silindiği kontrol edilir.
        productPage.removeCoupon();



    }

    @Test
    public void us21_Tc06() {

        //Belirtilen URL'e gidilir.
        //Login islemi yapilir.
        loginPage.login();

        //Search inputuna urun ismi girilir ve arama butonuna tiklanir.
        homePage.searchProduct();

        //Sayfada ki ilk urune tiklanilir ve urun sepete eklenir.
        productPage.firstProductAddCart();

        //Cart > VIEW CART sayfasina gidilir.
        productPage.goToViewCart();

        //Enter coupon cod here... inputuna kupon kodu girilir.
        //APPLY COUPON butonu tiklanir
        productPage.useCouponCode();

        //Kupon ile urune indirim tanimlandigi dogrulanir.
        productPage.checkCouponCodeUse();

        //PROCEED TO CHECKOUT butonuna tiklanir.
        productPage.goToProceedToCheckOut();

        //First name * inputu doldurulur.
        //Last name * inputu doldurulur.
        checkOutPage.firstAndLastNameRead();

        //Country / Region * dropdown'undan secim yapilir.
        checkOutPage.countrySelect();

        //Street address * inputu doldurulur.
        //Postcode / ZIP * inputu doldurulur.
        //Town / City * inputu doldurulur.
        checkOutPage.streetPostcodeAndTownCityRead();

        //Province * dropdown'undan secim yapilir.
        checkOutPage.provinceSelect();

        //Phone * inputu doldurulur.
        //Email address * inputu doldurulur.
        checkOutPage.phoneAndMailRead();

        //Odeme seceneklerinden secim yapilir.
        //PLACE ORDER butonu tılklanir.
        checkOutPage.payAtTheDoorAndPlaceOrder();

        //"Thank you. Your order has been received." mesaji goruntulendigi dogrulanir.
        orderCompletePage.checkShoopingEnd();
    }

    @AfterMethod
    public void afterTest() {
        Driver.closeDriver();
    }

}
