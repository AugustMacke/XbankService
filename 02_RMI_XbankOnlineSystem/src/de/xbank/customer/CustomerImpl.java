package de.xbank.customer;

import java.util.Set;
import java.util.HashMap;

import de.xbank.common.Account;
import de.xbank.common.Customer;
import de.xbank.common.InvalidLoginException;
import de.xbank.common.NoSessionException;

public class CustomerImpl implements Customer {
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private HashMap<String, Account> accounts;
	
	public CustomerImpl(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
		this.accounts = new HashMap<>();
	}

	@Override
	public Customer login(String userName, String password)
			throws InvalidLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout() throws NoSessionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
