package GenericUtils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Gautham Nayak
 * this class contains WebDriver utility methods.
 *
 */
public class WebDriverUtil {
	
	public void selectByText(WebElement element,String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(AutoConstants.timeforexplicitwait));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForTheElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(AutoConstants.timeforexplicitwait));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void pageLoadTimeOut(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AutoConstants.timeforimplicitwait));
	}
	
	public void switchFrameByIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToFrameByNameOrId(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void moveToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void switchToWindow(WebDriver driver,String title){
		
		Set<String>handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		while(it.hasNext()){
			String handle=it.next();
			String currentTitle=driver.switchTo().window(handle).getTitle();
			if(currentTitle.equalsIgnoreCase(title)) {
				break;
			}
			
		}
		
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		Actions actions=new Actions(driver);
		actions.scrollToElement(element);
	}
}
