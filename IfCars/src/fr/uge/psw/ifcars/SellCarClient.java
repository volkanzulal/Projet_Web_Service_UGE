package fr.uge.psw.ifcars;


import java.rmi.Naming;
import java.rmi.RemoteException;

public class SellCarClient {
    public static void main(String[] args) {
        try {
            ISellCar v = (ISellCar) Naming.lookup("SellCarServer");
            //v.add("Peugeot","206",1,1400,0);
            //v.add("Renault", "clio", 2, 2000, 1);
           // v.add("Mercedes","AMG",3,2000,1);
           // v.add("Volvo","S60",4,8000,1);
           // v.add("Mercedes","Class C",5,20000,1);
           // v.add("Volvo","C90",6,88000,1);
            //v.setNote(9,77);
            //List<ICar> l = v.lookModel("Clio");
            v.listCars().forEach(e-> {
                try {
                    System.out.println(e.getInformation());
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            });
        }catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}

