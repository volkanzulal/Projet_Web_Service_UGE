/**
 * Client.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.psw.clientws;

public interface Client extends java.rmi.Remote {
    public java.lang.String getFirstName() throws java.rmi.RemoteException;
    public java.lang.String getLastName() throws java.rmi.RemoteException;
    public java.lang.String getCountryCode() throws java.rmi.RemoteException;
    public void setFirstName(java.lang.String name) throws java.rmi.RemoteException;
    public void setLastName(java.lang.String name) throws java.rmi.RemoteException;
    public void setCodeCountry(java.lang.String codeCountry) throws java.rmi.RemoteException;
    public double getCompte() throws java.rmi.RemoteException;
    public void setCompte(double montant) throws java.rmi.RemoteException;
}
