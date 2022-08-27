package com.Boodmo;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtils.BaseClass;
import GenericUtils.WebDriverUtil;
import ObjectRepo.HomePage;
@Listeners(GenericUtils.ListnerS.class)

public class AdvanceTest extends BaseClass{
	
	
	WebDriverUtil wutil=new WebDriverUtil();
	
	@Test(groups="Regression Test")
	public void testSearchTextField() {
		HomePage hp=new HomePage(driver);
		hp.getSearchTextField().sendKeys("Honda");
		hp.getSearchButton().click();
		wutil.waitForVisibility(driver, hp.getSearchFrame());
		Assert.assertTrue(hp.getSearchFrame().isDisplayed(), "search frame is not displayed");
		
	}
	
	@Test(groups= {"Regression Test"},retryAnalyzer=GenericUtils.RetryAnalyzer.class)
	public void testDropDown() {
		HomePage hp=new HomePage(driver);
		wutil.selectByText(hp.getCarMakerDropDown(), " FORD ");
		Select sel=new Select(hp.getCarMakerDropDown());
		Assert.assertEquals("FORD",sel.getFirstSelectedOption().getText().trim());
		
		
	}
	
}
