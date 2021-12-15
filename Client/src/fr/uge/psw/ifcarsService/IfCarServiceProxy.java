package fr.uge.psw.ifcarsService;

public class IfCarServiceProxy implements fr.uge.psw.ifcarsService.IfCarService {
  private String _endpoint = null;
  private fr.uge.psw.ifcarsService.IfCarService ifCarService = null;
  
  public IfCarServiceProxy() {
    _initIfCarServiceProxy();
  }
  
  public IfCarServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIfCarServiceProxy();
  }
  
  private void _initIfCarServiceProxy() {
    try {
      ifCarService = (new fr.uge.psw.ifcarsService.IfCarServiceServiceLocator()).getIfCarService();
      if (ifCarService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ifCarService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ifCarService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ifCarService != null)
      ((javax.xml.rpc.Stub)ifCarService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.psw.ifcarsService.IfCarService getIfCarService() {
    if (ifCarService == null)
      _initIfCarServiceProxy();
    return ifCarService;
  }
  
  public double verificationAchat(double prix, int id, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    return ifCarService.verificationAchat(prix, id, countryCode);
  }
  
  public void initCompte(double montant) throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    ifCarService.initCompte(montant);
  }
  
  public boolean carDispo(int id) throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    return ifCarService.carDispo(id);
  }
  
  public double getPrix(int id) throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    return ifCarService.getPrix(id);
  }
  
  public double getCompteValeur() throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    return ifCarService.getCompteValeur();
  }
  
  public void resetCompte() throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    ifCarService.resetCompte();
  }
  
  public java.lang.String getCurrency(java.lang.String countryCode) throws java.rmi.RemoteException{
    if (ifCarService == null)
      _initIfCarServiceProxy();
    return ifCarService.getCurrency(countryCode);
  }
  
  
}