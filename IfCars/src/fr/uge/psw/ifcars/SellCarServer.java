package fr.uge.psw.ifcars;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SellCarServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ISellCar v = new SellCar();
            Naming.rebind("rmi://localhost:1099/SellCarServer", v);
        }catch (Exception e){
            System.out.println("Trouble: " + e);
        }
    }
}
