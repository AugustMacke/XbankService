package de.fh.winfo.se;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloWorldClient 
{

	public static void main(String[] args) 
	{
		try
		{
			Context context = new InitialContext();
			String lookupString = "ejb:03_HelloWorldEAR/03_HelloWorldEJB/HelloWorldServiceBean!de.fh.winfo.se.HelloWorldService";
			HelloWorldService remoteService = (HelloWorldService) context.lookup(lookupString);
			String result = remoteService.getHelloWorldString("Joe");
			System.out.println(result);
		}
		catch(NamingException ex)
		{
			System.out.println(ex);
		}

	}

}
