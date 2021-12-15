package fr.uge.psw.client;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IClient extends Remote {
    String getFirstName()throws RemoteException;
    String getLastName()throws RemoteException;
    String getCountryCode() throws RemoteException;
    void setFirstName(String name)throws RemoteException;
    void setLastName(String name)throws RemoteException;
    void setCodeCountry(String codeCountry)throws RemoteException;
    double getCompte() throws RemoteException;
    void setCompte(double montant) throws RemoteException;
}
