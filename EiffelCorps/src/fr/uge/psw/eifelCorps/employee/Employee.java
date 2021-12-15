package fr.uge.psw.eifelCorps.employee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Employee extends UnicastRemoteObject implements IEmployee{
    private String firstName;
    private String lastName;
    private int id;
    
	protected Employee() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName)throws RemoteException {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public int getId() {
		return id;
	}
	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
