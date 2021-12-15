package fr.uge.psw.clientws;



public class Client{
    private String firstName;
    private String lastName;
    private String codeCountry;
    private double compte;
    
    public Client()   {
    }


    
    public String getFirstName()   {
        return firstName;
    }

    
    public String getLastName()   {
        return lastName;
    }


    
    public String getCountryCode()  {
        return codeCountry;
    }

    
    public void setFirstName(String name)   {
        this.firstName =name;
    }

    
    public void setLastName(String name)   {
        this.lastName = name;
    }

 

    
    public void setCodeCountry(String codeCountry)   {
        this.codeCountry = codeCountry;
    }


	
	public double getCompte()   {
		return compte;
	}


	
	public void setCompte(double montant)   {
		this.compte = montant;
	}

}
