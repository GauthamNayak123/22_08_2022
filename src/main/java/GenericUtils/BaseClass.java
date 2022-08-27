package GenericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public WebDriver driver;
	public WebDriverUtil wdu=new WebDriverUtil();
	public JavaUtil jutil=new JavaUtil();
	public FileUtility futil=new FileUtility();
	public static WebDriver staticdriver;
	
	@BeforeSuite(groups= {"Smoke Test","Regression Test"})
	public void setupJDBC() {
		System.out.println("========JDBC Connection Established============");
	}
	
	@AfterSuite(groups= {"Smoke Test","Regression Test"})
	public void closeJDBC() {
		System.out.println("===========JDBC Connection closed==============");
		
	}
	
	@BeforeClass(groups= {"Smoke Test","Regression Test"})
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.get(futil.readDataFromPropertyFile("url"));
		wdu.maximizeWindow(driver);
		wdu.pageLoadTimeOut(driver);
		staticdriver=driver;
	}
	
	@AfterClass(groups= {"Smoke Test","Regression Test"})
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeMethod(groups= {"Smoke Test","Regression Test"})
	public void loginToApp() {
		System.out.println("=============logged in to Boodmos==============");
	}
	
	@AfterMethod(groups= {"Smoke Test","Regression Test"})
	public void logoutFromApp() {
		System.out.println("===============logged out from Boodmos===============");
	}
	
	public static String getscreenshot( String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);

		return destfile;
	}
	
	
}
