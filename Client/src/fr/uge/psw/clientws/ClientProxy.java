package fr.uge.psw.clientws;

public class ClientProxy implements fr.uge.psw.clientws.Client {
  private String _endpoint = null;
  private fr.uge.psw.clientws.Client client = null;
  
  public ClientProxy() {
    _initClientProxy();
  }
  
  public ClientProxy(String endpoint) {
    _endpoint = endpoint;
    _initClientProxy();
  }
  
  private void _initClientProxy() {
    try {
      client = (new fr.uge.psw.clientws.ClientServiceLocator()).getClient();
      if (client != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)client)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)client)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (client != null)
      ((javax.xml.rpc.Stub)client)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.psw.clientws.Client getClient() {
    if (client == null)
      _initClientProxy();
    return client;
  }
  
  public java.lang.String getFirstName() throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    return client.getFirstName();
  }
  
  public java.lang.String getLastName() throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    return client.getLastName();
  }
  
  public java.lang.String getCountryCode() throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    return client.getCountryCode();
  }
  
  public void setFirstName(java.lang.String name) throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    client.setFirstName(name);
  }
  
  public void setLastName(java.lang.String name) throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    client.setLastName(name);
  }
  
  public void setCodeCountry(java.lang.String codeCountry) throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    client.setCodeCountry(codeCountry);
  }
  
  public double getCompte() throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    return client.getCompte();
  }
  
  public void setCompte(double montant) throws java.rmi.RemoteException{
    if (client == null)
      _initClientProxy();
    client.setCompte(montant);
  }
  
  
}