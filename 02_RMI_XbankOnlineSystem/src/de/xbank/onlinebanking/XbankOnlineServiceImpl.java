package de.xbank.onlinebanking;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Set;
import java.util.logging.Logger;
import java.util.logging.Level;

import de.xbank.common.Account;
import de.xbank.common.Customer;
import de.xbank.common.NoSessionException;
import de.xbank.common.XbankOnlineService;
import de.xbank.customer.CustomerRegistry;

public class XbankOnlineServiceImpl implements XbankOnlineService
{

	private static Logger jlog = Logger.getLogger(XbankOnlineServiceImpl.class.getPackage().getName());
	
	@Override
	public boolean login(String username, String password)
			throws RemoteException 
	{
		Customer customer = CustomerRegistry.getInstance().findCustomerByName(username);
		if(customer != null && customer.getPassword().equals(password))
		{
			jlog.log(Level.FINE, "Login erfolgreich");
			return true;
		}
		else
		{
			jlog.log(Level.INFO, "Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch");
			return false;
		}
		
	}

	@Override
	public void logout() throws NoSessionException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Account> getMyAccounts() throws NoSessionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBalance(int accountID) throws NoSessionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal transfer(int fromAccount, int toAccount, BigDecimal amount)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
