package de.xbank.common;

import java.io.Serializable;
import java.util.Set;

public interface Customer extends Serializable
{
	public Customer login(String userName, String password) throws InvalidLoginException; //??

    public void logout() throws NoSessionException; //??

    public void addNewAccount(Account account);

    public Account getAccountById(int id);

    public Set<Account> getAccounts();

    @Override
    public String toString(); //??

    public String getUserName();

    public String getPassword();
}
