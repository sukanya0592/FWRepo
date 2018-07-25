package com.actitime.UserTest;

import org.testng.annotations.Test;

import com.actitime.GenericLib.BaseClass;

public class UserTest extends BaseClass{
	@Test(groups= {"smokeTest"})
	public void createUserTest()
	{
		System.out.println("Execute create UserTest");
	}
	@Test(groups= {"regressionTest"})
	public void modifyUserTest()
	{
		System.out.println("Execute modify UserTest");
	}
	@Test(groups= {"regressionTest"})
	public void deleteUserTest()
	{
		System.out.println("Execute Delete UserTest");
	}
}
