package fr.uge.psw.ifcars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.uge.psw.eifelCorps.employee.IEmployee;

public class Car extends UnicastRemoteObject implements ICar{

    private String marque;
    private String model;
    private long id;
    private double prix;
    private int note = -1;
    private int nb_location = 0;
    private boolean is_rent = false;
    private String etat = "CORRECT";
    private List<IEmployee> listEmployee = new ArrayList<IEmployee>();


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
    	if(rent == false) {
    		if(!this.listEmployee.isEmpty()) {
    			IEmployee e = listEmployee.get(0);
    			listEmployee.remove(0);
    			System.out.println("La voiture et maintenant loué a " + "d'ID "+id +e.getFirstName() +" "+ e.getLastName());
    			this.is_rent = true;
    			return;
    		}
    	}
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
        return  "ID:" + id + '\n' +
        		"Nb Location " + nb_location +'\n'+
        		"Marque:" + marque + '\n' +
                "Model:" + model + '\n' +
                "Prix:" + prix +'\n'+
                "Note : " + note +'\n'+
                "Etat: " + etat+ '\n'+
                "Loué: " + is_rent + '\n';
    }

	@Override
	public void rentCar(IEmployee e) throws RemoteException {
		if(this.is_rent == true) {
			System.out.println("Vous etes sur la liste d'attente.");
			listEmployee.add(e);
		}else {
			this.nb_location +=1;
			setIsRent(true);
		}
	}

	@Override
	public void renduCar(String etat, Integer note) throws RemoteException {
		if(etat != null){
			this.setEtat(etat);
		}
		if(note != null){
			this.setNote(note);
		}
		this.setIsRent(false);
	}
	
}
