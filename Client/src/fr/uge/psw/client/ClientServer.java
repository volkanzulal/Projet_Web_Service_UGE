package fr.uge.psw.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ClientServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1101);
            IClient c = new Client();
            Naming.rebind("rmi://localhost:1101/ClientServer", c);
        }catch (Exception e){
            System.out.println("Trouble: " + e);
        }
    }
}
