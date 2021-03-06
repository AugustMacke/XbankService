package de.xbank.client;

import java.math.BigDecimal;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Set;

import de.xbank.common.Account;
import de.xbank.common.XbankOnlineService;

public class SimpleOnlineBankingClient 
{
	//Testdaten:
	private static final String JOES_KONTO	="1";
	private static final String EMMAS_KONTO	="2";
	
	private static XbankOnlineService remoteSystem;
		
	public static void main(String[] args) 
	{
		try
		{
			System.setSecurityManager(new RMISecurityManager());
			
			Registry registry = LocateRegistry.getRegistry();
			System.out.println("Registry geladen: " + registry);
			
			XbankOnlineService remoteSystem;
			remoteSystem = (XbankOnlineService) registry.lookup(XbankOnlineService.INTERFACE_ID);
			
			System.out.println("Client hat folgendes Server-Objekt von der RMI-Registry erhalten");
			System.out.println(remoteSystem.toString());
			System.out.println();
			
			szenarioEmma();
			szenarioJoe();
			szenarioEmma();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
	
	
	/**
     * Test-Szenario: Emma meldet sich an und fragt ihren Kontostand ab.
     */
	private static void szenarioEmma() {
		try {
		   System.out.println("============================================================");			
	       String sessionID = remoteSystem.login("emma", "emma1");
		   System.out.println("Emma hat sich angemeldet, um ihren Kontostand abzufragen.");
		   BigDecimal kontostand = remoteSystem.getBalance(sessionID, EMMAS_KONTO);
	       System.out.println("Auf Emmas Konto " + EMMAS_KONTO + " betraegt der Saldo: " + kontostand);
	       remoteSystem.logout(sessionID);
		   System.out.println("Emma hat sich abgemeldet.");
		}
		catch (RemoteException e) {
			System.out.println(e);
		}
	}

    /**
     * Test-Szenario: Joe meldet sich an, fragt seine Konten ab und überweist an Emma
     */
	private static void szenarioJoe() {
		try {
		   System.out.println("============================================================");			
	       String sessionID = remoteSystem.login("joe", "joe1");
		   System.out.println("Joe hat sich angemeldet");
		   
	       Set<Account> joesKonten = remoteSystem.getMyAccounts(sessionID);
	       if (joesKonten.size()>0) {
	    	   //gib Joes Konten aus:
		       System.out.println("Joe hat folgende Konten:");
		       for (Account k : joesKonten) {
		    	   System.out.println(k);
		       }
		       System.out.println();
		       remoteSystem.transfer(sessionID, JOES_KONTO, EMMAS_KONTO, new BigDecimal(33));
		       System.out.println("Joe hat von Konto "+ JOES_KONTO +" 33 EUR an Konto " + EMMAS_KONTO + " ueberwiesen.");
		       BigDecimal saldo = remoteSystem.getBalance(sessionID, JOES_KONTO);
		       System.out.println("Der neue Saldo von Konto "+JOES_KONTO+" betraegt: " + saldo);
	       }
		   remoteSystem.logout(sessionID);
		   System.out.println("Joe hat sich abgemeldet.");
		}
		catch (RemoteException e) {
			System.out.println(e);
		}
	}
}