package fr.uge.psw.ifcars;

import fr.uge.psw.effeilcorps.IEmployee;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICar extends Remote {
    long getID() throws RemoteException;
    void setNblocation(int n)throws RemoteException;
    int getNblocation()throws RemoteException;
    String getInformation() throws RemoteException;
    String getMarque() throws RemoteException;
    String getModel() throws RemoteException;
    double getPrix() throws RemoteException;
    void setNote(int n) throws RemoteException;
    int getNote() throws RemoteException;
    String getEtat() throws RemoteException;
    void setEtat(String etat)throws RemoteException;
    boolean getIsRent()throws RemoteException;
    void setIsRent(boolean rent) throws RemoteException;
    void rentCar(IEmployee e) throws RemoteException;
}
