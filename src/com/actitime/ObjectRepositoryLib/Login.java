package com.actitime.ObjectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
//identify all the elements
	@FindBy(name="username")
	private WebElement usernameEdt;
	
	@FindBy(name="pwd")
	private WebElement passwordEdt;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
/*-------------------------------------------------*/

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
/*-------------------------------------------------*/	
//reusable Business Lib/Action
	public void login(String username, String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}

}
