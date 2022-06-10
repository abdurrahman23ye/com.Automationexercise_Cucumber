package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class MyStepdefs {
    MainPage mainPage=new MainPage();
    SignUp_Login signUp_login=new SignUp_Login();
    SignUpPage signUpPage=new SignUpPage();
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    Actions action=new Actions(Driver.getDriver());
    Faker fk=new Faker();
    String loginURL;
    ContactPage contactPage=new ContactPage();
    TestCasesPage testCasesPage=new TestCasesPage();

    @Given("Launch browser")
    public void launchBrowser() {}



    @And("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {

        Assert.assertTrue(mainPage.mainPage.isEnabled());


    }






    @And("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        Assert.assertTrue( signUp_login.newUserSignUpLabel.isDisplayed());
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {

        signUp_login.newUserSignUpName.sendKeys(ConfigReader.getProperty("dogruisim"));

        js.executeScript("window.scrollBy(0,150)");
        signUp_login.newUserSignUpEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));

        js.executeScript("window.scrollBy(0,-150)");
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        signUp_login.newUserSignUpButton.click();
    }


    @And("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        Assert.assertTrue(signUpPage.enterAccountInformation.isDisplayed());
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        signUpPage.inputTitle.click();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("signUpPassword")).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("dayOfBirthday")).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("monthOfBirthday")).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("yearOfBirthday")).perform();

    }


    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        action.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        action.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
    }

    @And("Select checkbox Receive special offers from our partners!Fill details: First name, Last name, Company, Address,")
    public void selectCheckboxReceiveSpecialOffersFromOurPartnersFillDetailsFirstNameLastNameCompanyAddress() {


        action.sendKeys(Keys.TAB).sendKeys(fk.name().name()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.name().lastName()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.company().name()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.address().fullAddress()).perform();
        action.sendKeys(Keys.TAB).sendKeys( fk.address().fullAddress()).perform();
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().country()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().state()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().city()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.address().zipCode()).perform();
        action.sendKeys(Keys.TAB).sendKeys(fk.phoneNumber().cellPhone()).perform();

    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        signUpPage.createAccount.click();
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {

        Assert.assertTrue(signUpPage.accountCreated.isDisplayed());
    }



    @And("Click Continue button")
    public void clickContinueButton() {
        signUpPage.accountCreatedContinue.click();
    }


    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        Assert.assertTrue(mainPage.loggedName.getText().equals(ConfigReader.getProperty("dogruisim")));

    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        mainPage.deleteAccount.click();
    }

    @And("Close the page")
    public void closeThePage() {
        Driver.closeDriver();
    }

    @Then("Navigate to url {string}")
    public void navigateToUrl(String string) {
        Driver.getDriver().get(ConfigReader.getProperty(string));
    }


    @And("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        Assert.assertTrue(signUp_login.loginLabel.isDisplayed());
        loginURL=Driver.getDriver().getCurrentUrl();
    }

    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {

        signUp_login.inputEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));

        action.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("signUpPassword")).perform();
    }

    @And("Click login button")
    public void clickLoginButton() {

        signUp_login.login.click();

    }

    @And("Enter incorrect email address and password")
    public void enterIncorrectEmailAddressAndPassword() {


        signUp_login.inputEmail.sendKeys(ConfigReader.getProperty("incorrectEmail"));

        js.executeScript("window.scrollBy(0,150)");

        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(ConfigReader.getProperty("inCorrectPassword")).perform();

        js.executeScript("window.scrollBy(0,-150)");



    }

    @And("Verify error Your email or password is incorrect! is visible")
    public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        Assert.assertTrue(signUp_login.loginerror.isDisplayed());
    }

    @Then("wait {int} seconds")
    public void waitSeconds(int arg0) {

        try {
            Thread.sleep(arg0*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Click on Signup  Login button")
    public void clickOnSignupLoginButton() {
        mainPage.loginLinki.click();
    }

    @And("Click Logout button")
    public void clickLogoutButton() {
        mainPage.logOut.click();
    }

    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {


        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(loginURL));

    }

    @And("Enter name and already registered email address")
    public void enterNameAndAlreadyRegisteredEmailAddress() {

        signUp_login.newUserSignUpName.sendKeys(ConfigReader.getProperty("dogruisim"));
        signUp_login.newUserSignUpEmail.sendKeys(ConfigReader.getProperty("dogruEmail"));
    }

    @And("Verify error Email Address already exist! is visible")
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {
        Assert.assertTrue(signUp_login.emailAlreadyExist.isDisplayed());
    }

    @And("Click on Contact Us button")
    public void clickOnContactUsButton() {

        contactPage.contactUsLink.click();
    }

    @And("Verify GET IN TOUCH is visible")
    public void verifyGETINTOUCHIsVisible() {


        js.executeScript("window.scrollBy(0,250)");
        Assert.assertTrue(contactPage.getInTouch.isDisplayed());
    }

    @And("Enter name, email, subject and message")
    public void enterNameEmailSubjectAndMessage() {

        contactPage.name.sendKeys(ConfigReader.getProperty("dogruisim"));

        action.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("dogruEmail")).perform();
        action.sendKeys(Keys.TAB).sendKeys("thanks to give us practicing opportunities").perform();
        action.sendKeys(Keys.TAB).sendKeys("thanks to give us practicing opportunities").perform();
    }

    @And("Upload file")
    public void uploadFile() {
        contactPage.file.sendKeys("C:\\Users\\asus\\Desktop\\290.txt");
    }

    @And("Click Submit button")
    public void clickSubmitButton() {
        contactPage.submit.click();
    }

    @And("Click OK button")
    public void clickOKButton() {

        Driver.getDriver().switchTo().alert().accept();
    }


    @And("Verify success message Success! Your details have been submitted successfully. is visible")
    public void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        Assert.assertTrue(contactPage.success.isDisplayed());
    }

    @And("Click Home button and verify that landed to home page successfully")
    public void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        contactPage.home.click();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),ConfigReader.getProperty("mainPage"));
    }

    @Given("Click on Test Cases button")
    public void clickOnTestCasesButton() {

        testCasesPage.TestCases.click();
    }

    @And("Verify user is navigated to test cases page successfully")
    public void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("testCasePage"));

    }
}
