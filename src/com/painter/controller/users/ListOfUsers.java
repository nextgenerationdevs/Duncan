package com.painter.controller.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfUsers
{
	static List<UserCloud> listOfUsers; 
	
	public static List<UserCloud> getI()
	{
		if (listOfUsers == null)
		{
			listOfUsers = Collections.synchronizedList(new ArrayList<UserCloud>());
		}
		return listOfUsers;
	}
}