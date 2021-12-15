package fr.uge.psw.ifcars;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface ISellCar extends Remote {
    boolean add(String marque,  String model, long id, double prix, int nb_location) throws RemoteException;
    List<ICar> lookModel(String model) throws RemoteException;
    List<ICar> lookMarque(String marque) throws RemoteException;
    List<ICar> listCars() throws RemoteException;
    void setNote(int note, long id) throws RemoteException;
    ICar del(long id) throws RemoteException;
    void setEtat(String etat,long id) throws RemoteException;
    void renduCar(String etat, Integer note, long id) throws RemoteException;
    ICar getCar(int id ) throws RemoteException;
}
