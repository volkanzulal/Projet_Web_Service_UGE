/**
 * ClientService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.psw.clientws;

public interface ClientService extends javax.xml.rpc.Service {
    public java.lang.String getClientAddress();

    public fr.uge.psw.clientws.Client getClient() throws javax.xml.rpc.ServiceException;

    public fr.uge.psw.clientws.Client getClient(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
