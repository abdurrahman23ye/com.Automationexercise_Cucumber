package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {

    public ProductPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//h2)[3]")
    public WebElement allProductsLabel;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement listedFirstProducts;

    @FindBy(xpath = "//a[@href='/product_details/2']")
    public WebElement listedSecondProducts;

    @FindBy(xpath = "(//a[@data-product-id=1])[1]")
    public WebElement listedFirstProductAddCart;


    @FindBy(xpath = "(//a[@data-product-id=2])[1]")
    public WebElement listedSecondProductAddCart;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//u")
    public WebElement viewCart;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement listedFirstProductsName;

    @FindBy(xpath = "//p[contains(text(),'Category')]")
    public WebElement listedFirstProductsCategory;

    @FindBy(xpath = "//span[contains(text(),'Rs.')]")
    public WebElement listedFirstProductsPrice;

    @FindBy(xpath = "//b[contains(text(),'Availability:')]")
    public WebElement listedFirstProductsAvailability;

    @FindBy(xpath = "//b[contains(text(),'Condition')]")
    public WebElement listedFirstProductsCondition;

    @FindBy(xpath = "//b[contains(text(),'Brand')]")
    public WebElement listedFirstProductsBrand;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "(//button)[1]")
    public WebElement searchButton;

    @FindBy(xpath = "(//h2)[3]")
    public WebElement searchedProducts;



    @FindBy(xpath = "//h2[@class='title text-center']") //navigated from main page
    public WebElement womanTopProducts;

    @FindBy(xpath = "(//a[@data-toggle='collapse'])[2]")
    public WebElement menCategory;

    @FindBy(xpath = "//a[@href='/category_products/6']")
    public  WebElement menSubCategoryJeans;

    @FindBy(xpath = "//h2[text()='Brands']")
    public  WebElement brandsLabel;

     @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    public WebElement brandPolo;

     @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement brandProductsLabel;

    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    public WebElement brandMadame;

    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[1]")
    public WebElement addCarttoProductAfterSearch;




}
