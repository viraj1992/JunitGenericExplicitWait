import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	WebDriver driver;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement waitforElement(By locator, long timeOutInSeconds) {
		WebElement element = null;
		try {
			System.out.println("Waiting for max: " + timeOutInSeconds + " seconds for element to be available");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the web page");
		} catch(Exception e) {
			System.out.println("Element not appeared on the web page");
		}
		return element;
	}
	
	public void clickWhenReady(By locator, long timeOutInSeconds) {	
		try {
			WebElement element;
			System.out.println("Waiting for max: " + timeOutInSeconds + " seconds for element to be available");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page");
		} catch(Exception e) {
			System.out.println("Element not clicked on the web page");
		}	
	}

}
