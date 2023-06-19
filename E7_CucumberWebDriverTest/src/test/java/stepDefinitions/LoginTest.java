package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver wd;
	
	@Given("open browser as {string}")
	public void openbrowser(String browser) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		
		WebDriverManager.chromedriver().setup();
		 wd = new ChromeDriver(options);
		
		
	}
	@When("enter url as {string}")
	public void enterurlas(String url) {
		wd.get(url);
	}

	@And("enter username as {string}")
	public void enterusername(String username) {
		wd.findElement(By.name("username")).sendKeys(username);;
	}

	@When("enter password as {string}")
	public void enterpassword(String password) {
		wd.findElement(By.name("password")).sendKeys(password);
	}

	@And("click login button")
	public void clickloginbutton() {
		wd.findElement(By.xpath("/html/body/main/div/div/div/div/form/div/button")).click();
	}

	@Then("verify the welcome page as {string} in header")
	public void verifythewelcomepage(String welcomemsg) {
		System.out.println(wd.getTitle() + welcomemsg);
	}

	@But("dont click remember password")
	public void dontclickrememberpassword() {
		System.out.println("---dont click remember password---");
	}

}
