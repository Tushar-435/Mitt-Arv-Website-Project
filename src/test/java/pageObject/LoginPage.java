package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
			
	WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // Locators
    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(id = "t2")
    WebElement sendOtpButton;

    @FindBy(css = "div.I17__otp__box input[type='number']")
    List<WebElement> otpInputs;

    @FindBy(xpath = "//p[contains(@class, 'profile_utility_route_desc') and contains(@class, 'Lg-body-01-medium')]")
    WebElement logoutLink;

    // Actions
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickSendOtpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendOtpButton)).click();
    }

    public void enterOtp(String otp) {
        wait.until(ExpectedConditions.visibilityOfAllElements(otpInputs));
        for (int i = 0; i < otp.length() && i < otpInputs.size(); i++) {
            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

    public void clickSignupButton() {
        // Assuming the sendOtpButton is also used for Signup
        wait.until(ExpectedConditions.elementToBeClickable(sendOtpButton)).click();
    }

    public void clickLogoutLink() {
        wait.until(ExpectedConditions.visibilityOf(logoutLink)).click();
    }
}