package team8_testngproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team8_testngproject.utilities.Driver;

import java.util.List;

public class P18_VendorProductManagerPage {
    public P18_VendorProductManagerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }






    // 20.Satır --> Ali





























    // 50.Satır --> Esra
    @FindBy(id = "wcfm_new_product_brand") public WebElement brandNameGur;
    @FindBy(xpath = "//*[@data-taxonomy='product_brand']") public WebElement addBrandButtonGur;
    @FindBy(xpath = "//ul[@id='product_brand']/li") public List<WebElement> brandListGur;
    @FindBy(id = "wcfm_new_parent_product_brand") public WebElement brandTaxonomyGur;
    @FindBy(xpath = "//input[@value='298']") public WebElement brandAppleGur;
    @FindBy(id = "product_tags") public WebElement addTagGur;
    @FindBy(xpath = "//*[text()='Choose from the most used tags']") public WebElement usedTagsLinkGur;
    @FindBy(xpath = "//*[contains(@class, 'position-1')]") public WebElement usedFirstTagGur;
    @FindBy(id = "catalog_visibility") public WebElement catalogSelectGur;
    @FindBy(name = "s") public WebElement searchBoxGur;
    @FindBy(xpath = "//*[@class='search-name']") public WebElement liveSearchAreaGur;


















    // 80.Satır --> Gonca





























    // 110.Satır --> Gürkay
    @FindBy(id = "product_type") public WebElement productMenuGur;
    @FindBy(id = "featured_img_display") public WebElement featuredImgGur;
    @FindBy(id = "gallery_img_gimage_0_display") public WebElement galleryImgGur;
    @FindBy(id = "menu-item-browse") public WebElement mediaLibraryGur;
    @FindBy(xpath = "(//*[@class='thumbnail'])[1]") public WebElement image1Gur;
    @FindBy(xpath = "(//*[@class='thumbnail'])[5]") public WebElement image2Gur;
    @FindBy(xpath = "//*[text()='Select']") public WebElement selectButtonGur;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-0']/div[4]/div/div[2]/button") public WebElement addGalleryButtonGur;
    @FindBy(id = "featured_img_remove_button") public WebElement removeImgBigGur;
    @FindBy(id = "gallery_img_gimage_0_remove_button") public WebElement removeImgSmallGur;
    @FindBy(id = "pro_title") public WebElement productTitleGur;
    @FindBy(xpath = "//input[@value='229']") public WebElement categoryAccessoriesGur;
    @FindBy(xpath = "//span[text()='Accessories']") public WebElement categoryAccessoriesTextGur;
    @FindBy(xpath = "//input[@value='406']") public WebElement categoryAppointmentGur;
    @FindBy(id = "wcfm_products_simple_submit_button") public WebElement submitButtonGur;
    @FindBy(xpath = "//*[@value='View']") public WebElement viewButtonGur;
    @FindBy(xpath = "//*[@class='product-thumbs-wrap slider-container slider-container-initialized slider-container-horizontal slider-container-free-mode swiper-container-thumbs']") public WebElement galleryImgDivGur;
    @FindBy(id = "excerpt_ifr") public WebElement shortIframeGur;
    @FindBy(tagName = "p") public WebElement shortIframe_P_TagGur;
    @FindBy(id = "description_ifr") public WebElement descriptionIframeGur;
    @FindBy(tagName = "p") public WebElement descIframe_P_TagGur;
    @FindBy(xpath = "//*[text()='+Add new category']") public WebElement addCategoryLinkGur;
    @FindBy(id = "wcfm_new_cat") public WebElement categoryNameGur;
    @FindBy(xpath = "//*[@data-taxonomy='product_cat']") public WebElement addButtonGur;
    @FindBy(xpath = "//ul[@id='product_cats_checklist']/li") public List<WebElement> categoryListGur;
    @FindBy(id = "wcfm_new_parent_cat") public WebElement parentCategoryGur;
    @FindBy(xpath = "//input[@value='446']") public WebElement brandAdidasGur;
    @FindBy(xpath = "//li[text()='Adidas']") public WebElement brandAdidasTextGur;
    @FindBy(xpath = "//*[text()='+Add new Product brands']") public WebElement addBrandLinkGur;
    // 140.Satır --> Hüseyin
    @FindBy(xpath = "//h2[.='Add Product']") public WebElement addProductTextHus;
@FindBy(id = "product_type") public  WebElement dropdownHus;




























    // 170.Satır --> Mehmet





























    // 200.Satır --> Meryem





























    // 230.Satır --> Zeliha





























    // 260.Satır --> Nurullah





























    // 290.Satır --> Ramazan





























    // 320.Satır --> Sevda





























    // 350.Satır --> Mustafa





























}
