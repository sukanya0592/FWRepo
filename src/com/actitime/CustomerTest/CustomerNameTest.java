package com.actitime.CustomerTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.GenericLib.BaseClass;
import com.actitime.GenericLib.FileUtils;

import com.actitime.ObjectRepositoryLib.CreateCustomer;
import com.actitime.ObjectRepositoryLib.Home;

import com.actitime.ObjectRepositoryLib.OpenTask;
import com.actitime.ObjectRepositoryLib.ProjectAndCustomer;

public class CustomerNameTest extends BaseClass{
@Test
public void createCustomerTest() throws Throwable
{
	// read the test data
	FileUtils lib=new FileUtils();
	String customerName=lib.getExcelData("Sheet1", 2, 2);
	
	//navigate to task page
	Home hp=PageFactory.initElements(driver, Home.class);
	hp.navigateToTaskPage();
	
	//click on project and customer link
	OpenTask op=PageFactory.initElements(driver, OpenTask.class);
	op.navigateToProjectAndCustPage();
	
	//click on create new customer page
	ProjectAndCustomer pandc=PageFactory.initElements(driver, ProjectAndCustomer.class);
	pandc.navigateCreateNewCustomerPage();
	
	//create customer
	CreateCustomer cc=PageFactory.initElements(driver, CreateCustomer.class);
	cc.createCustomer(customerName);
	
	//identify and verify the msg
	String actmsg=pandc.getSucMsg().getText();
	String expmsg="successfully created";
	boolean stat=actmsg.contains(expmsg);
	Assert.assertTrue(stat);
	
	
	//driver.close();
}

}
