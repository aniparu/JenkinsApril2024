package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.BaseClass;

public class FpPojo extends BaseClass{
	
	public FpPojo() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

	@FindBy(xpath="(//input[@name='email'])[2]")
	private WebElement fpBtn;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchEmail;
	
	
	
	public WebElement getFpBtn() {
		return fpBtn;
	}

	public WebElement getSearchEmail() {
		return searchEmail;
	}



}
