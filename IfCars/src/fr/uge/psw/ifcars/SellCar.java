package fr.uge.psw.ifcars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SellCar extends UnicastRemoteObject implements ISellCar {
	/**
	 * 
	 */
	private List<Car> cars;


	public SellCar() throws RemoteException {
		super();
		cars = new ArrayList<Car>();
	}



	@Override
	public boolean add(String marque, String model, long id, double prix, int nb_location) throws RemoteException {
		boolean doublon = false;
		for (Car car : cars) {
			if(car.getID() == id){
				doublon = true;
			}
		}
		if(!doublon)
			cars.add(new Car(marque,model,id,prix,nb_location));
		return  !doublon;
	}

	@Override
	public List<ICar> lookModel(String model) throws RemoteException {
		List lst = new ArrayList<Car>();
		for (Car c:cars) {
			if(c.getModel().equals(model))
				lst.add(c);
		}
		return lst;
	}

	@Override
	public List<ICar> lookMarque(String marque) throws RemoteException {
		List lst = new ArrayList<Car>();
		for (Car c:cars) {
			if(c.getMarque().equals(marque))
				lst.add(c);
		}
		return lst;
	}

	@Override
	public List<ICar> listCars() throws RemoteException{
		List lst = new ArrayList<Car>();
		for (Car c:cars) {
			lst.add(c);
		}
		return lst;
	}

	@Override
	public Car del(long id) throws RemoteException {
		synchronized (cars) {
			for (Car c:cars) {
				if(c.getID() == id){
					System.out.println(cars.remove(c));
					System.out.println("La voiture d'id " + id + " a été supprimer de la base");
					return c;
				}

			}
		}
		return null;
	}

	@Override
	public void setEtat(String etat, long id) throws RemoteException {
		for (Car car : cars) {
			if(car.getID() == id){
				car.setEtat(etat);
			}
		}
	}

	@Override
	public void setNote(int note,long id) throws RemoteException {
		for (Car car : cars) {
			if(car.getID() == id){
				car.setNote(note);
			}
		}
	}


	@Override
	public Car getCar(long id) throws RemoteException {
		for (Car car : cars) {
			if(car.getID() == id){
				return car;
			}
		}
		return null;
	}

}
