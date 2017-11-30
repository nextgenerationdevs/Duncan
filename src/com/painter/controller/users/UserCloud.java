package com.painter.controller.users;

public class UserCloud
{
	private String cloudUrl;
	private String cloudItem;
	private String loginOrEmail;
	private String password;
	
	public UserCloud() {}
	
	public UserCloud(String cloudUrl, String cloudItem, String loginOrEmail, String password)
	{
		this.cloudUrl = cloudUrl;
		this.cloudItem = cloudItem;
		this.loginOrEmail = loginOrEmail;
		this.password = password;
	}

	public String getCloudUrl()
	{
		return cloudUrl;
	}

	public void setCloudUrl(String cloudUrl)
	{
		this.cloudUrl = cloudUrl;
	}

	public String getCloudItem()
	{
		return cloudItem;
	}

	public void setCloudItem(String cloudItem)
	{
		this.cloudItem = cloudItem;
	}

	public String getLoginOrEmail()
	{
		return loginOrEmail;
	}

	public void setLoginOrEmail(String loginOrEmail)
	{
		this.loginOrEmail = loginOrEmail;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}	
}