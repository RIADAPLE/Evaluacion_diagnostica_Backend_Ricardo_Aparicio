
package org.example.webapp.jaxws.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 4.0.0-M4
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "CursoServicioWsImplService", targetNamespace = "http://services.jaxws.webapp.example.org/", wsdlLocation = "http://localhost:8081/webapp-jaxws-jpa/CursoServicioWsImpl?wsdl")
public class CursoServicioWsImplService
    extends Service
{

    private final static URL CURSOSERVICIOWSIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CURSOSERVICIOWSIMPLSERVICE_EXCEPTION;
    private final static QName CURSOSERVICIOWSIMPLSERVICE_QNAME = new QName("http://services.jaxws.webapp.example.org/", "CursoServicioWsImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/webapp-jaxws-jpa/CursoServicioWsImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CURSOSERVICIOWSIMPLSERVICE_WSDL_LOCATION = url;
        CURSOSERVICIOWSIMPLSERVICE_EXCEPTION = e;
    }

    public CursoServicioWsImplService() {
        super(__getWsdlLocation(), CURSOSERVICIOWSIMPLSERVICE_QNAME);
    }

    public CursoServicioWsImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CURSOSERVICIOWSIMPLSERVICE_QNAME, features);
    }

    public CursoServicioWsImplService(URL wsdlLocation) {
        super(wsdlLocation, CURSOSERVICIOWSIMPLSERVICE_QNAME);
    }

    public CursoServicioWsImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CURSOSERVICIOWSIMPLSERVICE_QNAME, features);
    }

    public CursoServicioWsImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CursoServicioWsImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CursoServicioWs
     */
    @WebEndpoint(name = "CursoServicioWsImplPort")
    public CursoServicioWs getCursoServicioWsImplPort() {
        return super.getPort(new QName("http://services.jaxws.webapp.example.org/", "CursoServicioWsImplPort"), CursoServicioWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CursoServicioWs
     */
    @WebEndpoint(name = "CursoServicioWsImplPort")
    public CursoServicioWs getCursoServicioWsImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.jaxws.webapp.example.org/", "CursoServicioWsImplPort"), CursoServicioWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CURSOSERVICIOWSIMPLSERVICE_EXCEPTION!= null) {
            throw CURSOSERVICIOWSIMPLSERVICE_EXCEPTION;
        }
        return CURSOSERVICIOWSIMPLSERVICE_WSDL_LOCATION;
    }

}
