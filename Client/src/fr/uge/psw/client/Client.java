package fr.uge.psw.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Client extends UnicastRemoteObject implements IClient{
    private String firstName;
    private String lastName;
    private String codeCountry;
    private double compte;
    
    protected Client() throws RemoteException {
    }


    @Override
    public String getFirstName() throws RemoteException {
        return firstName;
    }

    @Override
    public String getLastName() throws RemoteException {
        return lastName;
    }


    @Override
    public String getCountryCode() throws RemoteException {
        return codeCountry;
    }

    @Override
    public void setFirstName(String name) throws RemoteException {
        this.firstName =name;
    }

    @Override
    public void setLastName(String name) throws RemoteException {
        this.lastName = name;
    }

 

    @Override
    public void setCodeCountry(String codeCountry) throws RemoteException {
        this.codeCountry = codeCountry;
    }


	@Override
	public double getCompte() throws RemoteException {
		return compte;
	}


	@Override
	public void setCompte(double montant) throws RemoteException {
		this.compte = montant;
	}

}
