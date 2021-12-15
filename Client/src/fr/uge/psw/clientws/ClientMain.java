package fr.uge.psw.clientws;

import fr.uge.psw.ifcarsService.IfCarService;
import fr.uge.psw.ifcarsService.IfCarServiceServiceLocator;


public class ClientMain {
    public static void main(String[] args) {
        try {
        	Client client = (Client) new ClientServiceLocator().getClient();
        	((ClientSoapBindingStub) client).setMaintainSession(true);
        	IfCarService cs = new IfCarServiceServiceLocator().getIfCarService();
        	client.setCompte(20000); 
        	client.setFirstName("Leonardo");
            client.setLastName("VNCI");
            client.setCodeCountry("USA");
            System.out.println(client.getCompte() +" " +client.getCountryCode());
        	cs.initCompte(client.getCompte());
        	
        	System.out.println(cs.getPrix(3) + " EUR");
        	cs.verificationAchat(cs.getPrix(3), 3, client.getCountryCode());
        	
        	System.out.println(cs.getCompteValeur() +" "+cs.getCurrency(client.getCountryCode()));
        }catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}
