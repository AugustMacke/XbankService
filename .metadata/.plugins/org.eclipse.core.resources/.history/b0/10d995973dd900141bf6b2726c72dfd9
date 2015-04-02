package de.xbank.common;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Account extends Serializable
{
	public int getId();

    public BigDecimal getAmount();
    
    public Customer getOwner();

    public void increase(BigDecimal amount);

    public void decrease(BigDecimal amount);

}
