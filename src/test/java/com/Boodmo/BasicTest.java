package com.Boodmo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtils.BaseClass;
import GenericUtils.ExcelUtil;
import GenericUtils.WebDriverUtil;
import ObjectRepo.HomePage;
import junit.framework.Assert;
@Listeners(GenericUtils.ListnerS.class)
public class BasicTest extends BaseClass {
	public ExcelUtil eutil=new ExcelUtil();
	WebDriverUtil wdutil=new WebDriverUtil();
	
	@Test(groups= {"Smoke Test"})
	public void testHomePageDisplayed() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		wdutil.waitForVisibility(driver, hp.getSearchTextField());
		Assert.assertTrue(hp.getSearchButton().isDisplayed());
		
	}
	
}
