package fr.uge.psw.ifcarsService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;

import fr.uge.psw.banqueService.Banque;
import fr.uge.psw.banqueService.BanqueServiceLocator;
import fr.uge.psw.banqueService.BanqueSoapBindingStub;
import fr.uge.psw.ifcars.ISellCar;

public class IfCarService {
	ISellCar cars = (ISellCar) Naming.lookup("SellCarServer");
	Banque compte;
	public IfCarService() throws MalformedURLException, RemoteException, NotBoundException, ServiceException {
		compte = new BanqueServiceLocator().getBanque(); 
		((BanqueSoapBindingStub) compte).setMaintainSession(true);  
	}
	
	public void resetCompte() throws RemoteException {
		compte.retraitDe(compte.valeurDuSolde());
	}
	
	public void initCompte(double montant) throws ServiceException, RemoteException {
		this.resetCompte();
		compte.depotDe(montant);
	}
	
	public double verificationAchat(double prix, int id, String countryCode) throws RemoteException, ServiceException {
		String currency  = new CurrencyServerLocator().getCurrencyServerSoap().countryToCurrency(null, countryCode, false);
		double montant =  (double) new CurrencyServerLocator().getCurrencyServerSoap().convert(null, "EUR",currency, prix, false, null, CurncsrvReturnRate.curncsrvReturnRateNumber, null, null);
		
		if(montant <= compte.valeurDuSolde() && cars.getCar(id).getNblocation()>0) {
			compte.retraitDe(montant);
			cars.del(id);
			return compte.valeurDuSolde();
		}
		
		if(cars.getCar(id).getNblocation()<=0) {
			System.out.println("La voiture n'est pas a vendre");
			return compte.valeurDuSolde();
		}
		
		System.out.println("Vous avez pas assez d'argent pour vous offrir cette voiture.");
		return compte.valeurDuSolde();
	}
	
	public String getCurrency(String countryCode) throws RemoteException, ServiceException {
		return new CurrencyServerLocator().getCurrencyServerSoap().countryToCurrency(null, countryCode, false);
	}
	
	public boolean carDispo(int id) throws RemoteException {
		return !cars.getCar(id).getIsRent();
	}

	public double getPrix(int id) throws RemoteException {
		return cars.getCar(id).getPrix();
	}
	
	public double getCompteValeur() throws RemoteException {
		return compte.valeurDuSolde();
	}


}
