package fr.uge.psw.eifelCorps.employee;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmployee extends Remote {
	String getFirstName() throws RemoteException;
	int getId() throws RemoteException;
	String getLastName() throws RemoteException;
	void setFirstName(String firstName) throws RemoteException;
	void setId(int id) throws RemoteException;
	void setLastName(String lastName)throws RemoteException;
}

