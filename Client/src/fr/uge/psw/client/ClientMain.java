package fr.uge.psw.client;
import fr.uge.psw.ifcarsService.IfCarService;
import fr.uge.psw.ifcarsService.IfCarServiceServiceLocator;
import java.rmi.Naming;

public class ClientMain {
    public static void main(String[] args) {
        try {
        	IClient client = (IClient) Naming.lookup("rmi://localhost:1101/ClientServer");
        	IfCarService cs = new IfCarServiceServiceLocator().getIfCarService();
        	
        	client.setCompte(20000); 
        	client.setFirstName("Leonardo");
            client.setLastName("VNCI");
            client.setCodeCountry("USA");
        	cs.initCompte(client.getCompte());
        	
        	System.out.println(cs.getPrix(2) + " EUR");
        	cs.verificationAchat(cs.getPrix(2), 2, client.getCountryCode());
        	
        	System.out.println(cs.getCompteValeur() +" "+cs.getCurrency(client.getCountryCode()));
        }catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}
