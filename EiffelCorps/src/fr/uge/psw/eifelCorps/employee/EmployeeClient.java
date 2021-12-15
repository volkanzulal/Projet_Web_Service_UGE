package fr.uge.psw.eifelCorps.employee;

import java.rmi.Naming;
import java.rmi.RemoteException;

import fr.uge.psw.ifcars.ISellCar;



public class EmployeeClient {
	public static void main(String[] args) {
		 try {
	        	IEmployee employee = (IEmployee) Naming.lookup("rmi://localhost:1100/EmployeeServeur");
	        	ISellCar cars = (ISellCar) Naming.lookup("rmi://localhost:1099/SellCarServer");
	        	employee.setFirstName("John");
	        	employee.setLastName("Doe");
	        	employee.setId(0);
	        	
	        	//System.out.println(employee.getFirstName()+ " " +employee.getLastName() 
	        	//+ " " + employee.getId());
	        	
	        	//cars.getCar(4).rentCar(employee);
	        	
	        	//System.out.println(cars==null);
	        	
	        	//cars.getCar(1).renduCar("RAS", 8);
	        	
	        	cars.listCars().forEach(c-> {
                    try {
                        System.out.println(c.getInformation());
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                });
	        }catch (Exception e){
	            System.out.println("Exception " + e);
	        }
	}
}
