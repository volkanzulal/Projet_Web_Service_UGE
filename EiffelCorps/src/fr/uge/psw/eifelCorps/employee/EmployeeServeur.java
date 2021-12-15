package fr.uge.psw.eifelCorps.employee;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class EmployeeServeur {
	public static void main(String[] args) {
		 try {
	            LocateRegistry.createRegistry(1100);
	            IEmployee e = new Employee();
	            Naming.rebind("rmi://localhost:1100/EmployeeServeur", e);
	        }catch (Exception e){
	            System.out.println("Trouble: " + e);
	        }
	}
}
