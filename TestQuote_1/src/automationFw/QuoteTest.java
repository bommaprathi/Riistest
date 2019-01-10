package automationFw;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuoteTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
//Setting the chrome driver setting
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = "https://www.aaalife.com/term-life-insurance-quote-input";
		driver.get(url);
		driver.findElement(By.id("zip")).clear();
		driver.findElement(By.id("zip")).sendKeys("48044");
		selectDropdown("gender", "Female");
		selectDropdown("month", "June");
		selectDropdown("day", "14");
		selectDropdown("year", "1989");
		driver.findElement(By.id("isMemberYes")).click();
		driver.findElement(By.id("contact_email")).sendKeys("bommaprathi@gmail.com");
		selectDropdown("feet", "5");
		selectDropdown("inches", "4");
		driver.findElement(By.id("weight")).sendKeys("150");
		driver.findElement(By.id("nicotineUseYes")).click();
//We need to determine the rate of your health
		boolean rateYourHealth = driver.findElement(By.xpath("//*[text()='Rate Your Health']")).isDisplayed();
		if (rateYourHealth) {
			selectDropdown("rateYourHealth", "Good");
		}
		selectDropdown("coverageAmount", "$250,000");
		selectDropdown("termLength", "10 Years");
		
		driver.findElement(By.id("seeQuote")).click();

	//	driver.close();
	}

	public static void selectDropdown(String id, String value) {
		// This method will add id and value as input in order to populate respective
		// dropdown
		Select drpGender = new Select(driver.findElement(By.id(id)));
		drpGender.selectByVisibleText(value);
	}

}
