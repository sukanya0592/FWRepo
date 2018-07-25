package com.actitime.ObjectRepositoryLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCustomer {
    @FindBy(name="name")
    private WebElement custmerNameEdt;
    @FindBy(name="description")
    private WebElement customerdescriptionEdt;
    @FindBy(name="createCustomerSubmit")
    private WebElement createCustomerBtn;
    
    //overloaded mtd
    public void createCustomer(String customerName)
    {
    	custmerNameEdt.sendKeys(customerName);
    	createCustomerBtn.click();
    }
    public void createCustomer(String customerName, String desc)
    {
    	custmerNameEdt.sendKeys(customerName);
    	customerdescriptionEdt.sendKeys(desc);
    	createCustomerBtn.click();
    }
}
