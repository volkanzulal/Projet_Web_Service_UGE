/**
 * IfCarService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.psw.ifcarsService;

public interface IfCarService extends java.rmi.Remote {
    public java.lang.String getCurrency(java.lang.String countryCode) throws java.rmi.RemoteException;
    public double getCompteValeur() throws java.rmi.RemoteException;
    public double verificationAchat(double prix, int id, java.lang.String countryCode) throws java.rmi.RemoteException;
    public void resetCompte() throws java.rmi.RemoteException;
    public void initCompte(double montant) throws java.rmi.RemoteException;
    public boolean carDispo(int id) throws java.rmi.RemoteException;
    public double getPrix(int id) throws java.rmi.RemoteException;
}
