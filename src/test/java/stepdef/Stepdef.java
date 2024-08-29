package stepdef;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class Stepdef {
//}
//	 WebDriver driver;
//	    WebDriverWait wait;
//	    LoginPage loginPage;
	
	 WebDriver driver;
	    LoginPage loginPage;
	    
	    @Given("user Launch Chrome Browser")
	    public void user_launch_chrome_browser() {
	        ChromeOptions option = new ChromeOptions();
	        option.addArguments("--remote-allow-origins=*");
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(option);
	        loginPage = new LoginPage(driver);
	    }

	    @When("User opens url {string}")
	    public void user_opens_url(String url) {
	        driver.get(url);
	        driver.manage().window().maximize();
	    }

	    @When("User enters Email as {string}")
	    public void user_enters_email_as(String email) {
	        loginPage.enterEmail(email);
	    }

	    @When("User clicks on {string} button")
	    public void user_clicks_on_button(String buttonName) {
	            loginPage.clickSendOtpButton();
	    }

	    @Then("User should be redirected to the OTP submission page")
	    public void user_should_be_redirected_to_the_otp_submission_page() {
	        // Verify redirection or presence of OTP inputs
	        // Example: assertTrue(driver.getCurrentUrl().contains("/otp"));
	    }

	    @When("User is prompted to enter the OTP manually")
	    public void user_is_prompted_to_enter_the_otp_manually() {
	        // Assuming OTP inputs are already visible, you can get them directly from the POM
	    	
	    	 Scanner scanner = new Scanner(System.in);
	         System.out.print("Please enter the OTP: ");
	         String otp = scanner.nextLine();
	        loginPage.enterOtp(otp);
	    }

	    @Then("User enters the OTP")
	    public void user_enters_the_otp() {
	        // This step is handled in the `user_is_prompted_to_enter_the_otp_manually` method
	    }

	    @Then("User clicks on the {string} button")
	    public void user_clicks_on_the_button(String buttonName) {
	            loginPage.clickSignupButton();
	        }
	    

	    @Then("The user should be redirected to the dashboard with the title {string}")
	    public void the_user_should_be_redirected_to_the_dashboard_with_the_title(String title) throws InterruptedException {
	        // Validate the title or some element on the dashboard
	        // Example: assertEquals(title, driver.getTitle());
	    	Thread.sleep(3000);
	    }

	    @When("User clicks on the {string} link")
	    public void user_clicks_on_the_link(String linkName) {
	            loginPage.clickLogoutLink();
	        }
	    

	    @Then("User should be logged out successfully")
	    public void user_should_be_logged_out_successfully() throws InterruptedException {
	        // Verify logout success, e.g., check for login page
	        // Example: assertTrue(driver.getCurrentUrl().contains("/login"));
	    	Thread.sleep(3000);
	    }

	    @Then("User closes the Browser")
	    public void user_closes_the_browser() {
	            driver.quit();
	        }
	    }
	
