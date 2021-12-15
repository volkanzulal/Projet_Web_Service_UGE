package fr.uge.psw.banqueService;

public class BanqueProxy implements fr.uge.psw.banqueService.Banque {
  private String _endpoint = null;
  private fr.uge.psw.banqueService.Banque banque = null;
  
  public BanqueProxy() {
    _initBanqueProxy();
  }
  
  public BanqueProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueProxy();
  }
  
  private void _initBanqueProxy() {
    try {
      banque = (new fr.uge.psw.banqueService.BanqueServiceLocator()).getBanque();
      if (banque != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banque)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banque != null)
      ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.psw.banqueService.Banque getBanque() {
    if (banque == null)
      _initBanqueProxy();
    return banque;
  }
  
  public void depotDe(double montant) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.depotDe(montant);
  }
  
  public boolean retraitDe(double montant) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.retraitDe(montant);
  }
  
  public double valeurDuSolde() throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.valeurDuSolde();
  }
  
  
}