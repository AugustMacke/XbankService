package de.xbank.onlinebanking;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;
import java.util.logging.Level;

import de.xbank.banking.AccountImpl;
import de.xbank.common.Account;
import de.xbank.common.Customer;
import de.xbank.common.XbankOnlineService;
import de.xbank.customer.CustomerImpl;

public class OnlineBankingSystemMain
{
	private static Logger jlog = Logger.getLogger(XbankOnlineServiceImpl.class.getPackage().getName());

	public static void main(String[] args) 
	{
		System.setSecurityManager(new RMISecurityManager());
		
		try
		{
			Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			jlog.log(Level.FINE, "Registry gestartet: " + registry);
			XbankOnlineService xbankOnlineServiceStub = (XbankOnlineService) UnicastRemoteObject.
															exportObject(new XbankOnlineServiceImpl(), 0);
			registry.rebind(XbankOnlineService.INTERFACE_ID, xbankOnlineServiceStub);
			jlog.log(Level.FINE, "Interface in Registry angemeldet. Warte auf Requests...");
			
			Customer joe = new CustomerImpl("joe", "joe1");
			Customer emma = new CustomerImpl("emma", "emma1");
			Account joesAccount = new AccountImpl(joe);
			Account emmasAccount = new AccountImpl(emma);
			jlog.log(Level.FINE, "Neu angelegt: " + joesAccount);
			jlog.log(Level.FINE, "Neu angelegt: " + emmasAccount);
		}
		catch(RemoteException ex)
		{
			jlog.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

}
