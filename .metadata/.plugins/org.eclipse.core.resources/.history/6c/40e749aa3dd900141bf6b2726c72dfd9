package de.xbank.banking;

import java.math.BigDecimal;

import de.xbank.common.Account;
import de.xbank.common.Customer;
import de.xbank.util.IdGenerator;

public class AccountImpl implements Account {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private BigDecimal amount;
	private Customer owner;
	
	public AccountImpl(Customer owner) {
		this.id = IdGenerator.getFreeID();//Integer.toString(IdGenerator.getFreeID());
		this.amount = BigDecimal.ZERO;
		this.owner = owner;
		this.owner.addNewAccount(this);
		AccountRegistry.getInstance().addKonto(this);
	}
	
	/* (non-Javadoc)
	 * @see de.wifhm.se1.banking.server.kontoverwaltung.Konto#getKontoNr()
	 */
	@Override
	public int getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see de.wifhm.se1.banking.server.kontoverwaltung.Konto#getBetrag()
	 */
	@Override
	public BigDecimal getAmount() {
		return amount;
	}
	
	/* (non-Javadoc)
	 * @see de.wifhm.se1.banking.server.kontoverwaltung.Konto#getInhaber()
	 */
	@Override
	public Customer getOwner() {
		return owner;
	}
	
	/* (non-Javadoc)
	 * @see de.wifhm.se1.banking.server.kontoverwaltung.Konto#increase(java.math.BigDecimal)
	 */
	@Override
	public void increase(BigDecimal amount) {
		this.amount = this.amount.add(amount);
	}
	
	/* (non-Javadoc)
	 * @see de.wifhm.se1.banking.server.kontoverwaltung.Konto#decrease(java.math.BigDecimal)
	 */
	@Override
	public void decrease(BigDecimal amount) {
		this.amount = this.amount.subtract(amount);
	}
	
	public String toString() {
		return "Account " + this.id + " (Balance=" + this.amount + ", Owner=" + this.getOwner().getUserName() + ")";
	}
	
}