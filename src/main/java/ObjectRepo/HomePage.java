package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//select[@formcontrolname='carMaker']")
	private WebElement carMakerDropDown;
	
	@FindBy(xpath="//div[text()=' Search ']")
	private WebElement searchFrame;
	
	public WebElement getSearchFrame() {
		return searchFrame;
	}
	
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	
	public WebElement getSearchButton() {
		return searchButton;
	}


	public WebElement getCarMakerDropDown() {
		return carMakerDropDown;
	}

	
}
