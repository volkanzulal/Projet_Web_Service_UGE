/**
 * BanqueService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.psw.banqueService;

public interface BanqueService extends javax.xml.rpc.Service {
    public java.lang.String getBanqueAddress();

    public fr.uge.psw.banqueService.Banque getBanque() throws javax.xml.rpc.ServiceException;

    public fr.uge.psw.banqueService.Banque getBanque(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
