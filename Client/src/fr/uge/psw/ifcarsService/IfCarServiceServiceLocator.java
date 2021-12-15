/**
 * IfCarServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.psw.ifcarsService;

public class IfCarServiceServiceLocator extends org.apache.axis.client.Service implements fr.uge.psw.ifcarsService.IfCarServiceService {

    public IfCarServiceServiceLocator() {
    }


    public IfCarServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IfCarServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IfCarService
    private java.lang.String IfCarService_address = "http://localhost:8080/IfCars/services/IfCarService";

    public java.lang.String getIfCarServiceAddress() {
        return IfCarService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IfCarServiceWSDDServiceName = "IfCarService";

    public java.lang.String getIfCarServiceWSDDServiceName() {
        return IfCarServiceWSDDServiceName;
    }

    public void setIfCarServiceWSDDServiceName(java.lang.String name) {
        IfCarServiceWSDDServiceName = name;
    }

    public fr.uge.psw.ifcarsService.IfCarService getIfCarService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IfCarService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIfCarService(endpoint);
    }

    public fr.uge.psw.ifcarsService.IfCarService getIfCarService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.uge.psw.ifcarsService.IfCarServiceSoapBindingStub _stub = new fr.uge.psw.ifcarsService.IfCarServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIfCarServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIfCarServiceEndpointAddress(java.lang.String address) {
        IfCarService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.uge.psw.ifcarsService.IfCarService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.uge.psw.ifcarsService.IfCarServiceSoapBindingStub _stub = new fr.uge.psw.ifcarsService.IfCarServiceSoapBindingStub(new java.net.URL(IfCarService_address), this);
                _stub.setPortName(getIfCarServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IfCarService".equals(inputPortName)) {
            return getIfCarService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ifcarsService.psw.uge.fr", "IfCarServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ifcarsService.psw.uge.fr", "IfCarService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IfCarService".equals(portName)) {
            setIfCarServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
