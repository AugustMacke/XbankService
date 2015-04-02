package de.xbank.common;

import java.math.BigDecimal;
import java.util.Set;
import java.rmi.*;

public interface XbankOnlineService extends Remote
{
	public static final String INTERFACE_ID = "XbankOnlineService";
	
	public boolean login(String username, String password)
            throws RemoteException;

    public void logout()
            throws NoSessionException;

    public Set<Account> getMyAccounts()
            throws NoSessionException;

    public BigDecimal getBalance(int accountID)
            throws NoSessionException;

    public BigDecimal transfer(int fromAccount,
                               int toAccount,
                               BigDecimal amount)
            throws RemoteException;
}
