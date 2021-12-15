package fr.uge.psw.ifcars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Objects;

import fr.uge.psw.effeilcorps.IEmployee;

public class Car extends UnicastRemoteObject implements ICar{

    private String marque;
    private String model;
    private long id;
    private double prix;
    private int note = -1;
    private int nb_location;
    private boolean is_rent = false;
    private String etat = "CORRECT";
    private List<IEmployee> listEmployee;


    public Car() throws RemoteException {
        super();
    }

    public Car(String marque, String model,  long id,double prix, int nb_location) throws RemoteException{
        this.marque = marque;
        this.model = model;
        this.prix = prix;
        this.id = id;
        this.nb_location = nb_location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public void setNote(int note) throws RemoteException {
        if(note < 0 || note > 10){
            throw new IllegalArgumentException("La note doit etre comprise ente 0 et 10");
        }
        this.note = note;
    }

    @Override
    public int getNote() throws RemoteException {
        return this.note;
    }

    @Override
    public String getEtat() throws RemoteException {
        return this.etat;
    }

    @Override
    public void setEtat(String etat) throws RemoteException {
        this.etat = etat;
    }

    @Override
    public boolean getIsRent() throws RemoteException {
        return is_rent;
    }

    @Override
    public void setIsRent(boolean rent) throws RemoteException {
        this.is_rent = rent;
    }

    @Override
    public String getMarque() {
        return marque;
    }
    @Override
    public String getModel() {
        return model;
    }

    @Override
    public long getID() throws RemoteException {
        return this.id;
    }

    @Override
    public void setNblocation(int n) throws RemoteException {
        this.nb_location = n;
    }

    @Override
    public int getNblocation() throws RemoteException {
        return nb_location;
    }

    @Override
    public String getInformation() throws RemoteException {
        return  "Marque:" + marque + '\n' +
                "Model:" + model + '\n' +
                "Plaque:" + id + '\n' +
                "Prix:" + prix +'\n'+
                "Note : " + note +'\n'+
                "Etat: " + etat+ '\n'+
                "Loué: " + is_rent + '\n';
    }

	@Override
	public void rentCar(IEmployee e) throws RemoteException {
		if(this.getIsRent() == true) {
			System.out.println("Vous etes sur la liste d'attente.");
			listEmployee.add(e);
		}else {
			setIsRent(true);
		}
	}
	
}
