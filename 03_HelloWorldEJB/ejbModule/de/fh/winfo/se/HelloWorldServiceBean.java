package de.fh.winfo.se;

//import javax.ejb.Local;
//import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldServiceBean
 */
@Stateless
@Remote(HelloWorldService.class)
public class HelloWorldServiceBean implements HelloWorldService 
{
	/**
     * @see HelloWorldService#getHelloWorldString(String)
     */
	@Override
    public String getHelloWorldString(String name) 
    {    	
		return "Hello " + name;
    }

}