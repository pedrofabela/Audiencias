
package mx.gob.edomex.dgsei.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConsultaRenapoPorCurp", targetNamespace = "http://ws.dgsei.edomex.gob.mx/", wsdlLocation = "http://tramitesyservicios.edomex.gob.mx/WebServiceRenapo/ConsultaRenapoPorCurp?wsdl")
public class ConsultaRenapoPorCurp_Service
    extends Service
{

    private final static URL CONSULTARENAPOPORCURP_WSDL_LOCATION;
    private final static WebServiceException CONSULTARENAPOPORCURP_EXCEPTION;
    private final static QName CONSULTARENAPOPORCURP_QNAME = new QName("http://ws.dgsei.edomex.gob.mx/", "ConsultaRenapoPorCurp");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://tramitesyservicios.edomex.gob.mx/WebServiceRenapo/ConsultaRenapoPorCurp?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONSULTARENAPOPORCURP_WSDL_LOCATION = url;
        CONSULTARENAPOPORCURP_EXCEPTION = e;
    }

    public ConsultaRenapoPorCurp_Service() {
        super(__getWsdlLocation(), CONSULTARENAPOPORCURP_QNAME);
    }

    public ConsultaRenapoPorCurp_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONSULTARENAPOPORCURP_QNAME, features);
    }

    public ConsultaRenapoPorCurp_Service(URL wsdlLocation) {
        super(wsdlLocation, CONSULTARENAPOPORCURP_QNAME);
    }

    public ConsultaRenapoPorCurp_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONSULTARENAPOPORCURP_QNAME, features);
    }

    public ConsultaRenapoPorCurp_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultaRenapoPorCurp_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ConsultaRenapoPorCurp
     */
    @WebEndpoint(name = "ConsultaRenapoPorCurpPort")
    public ConsultaRenapoPorCurp getConsultaRenapoPorCurpPort() {
        return super.getPort(new QName("http://ws.dgsei.edomex.gob.mx/", "ConsultaRenapoPorCurpPort"), ConsultaRenapoPorCurp.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConsultaRenapoPorCurp
     */
    @WebEndpoint(name = "ConsultaRenapoPorCurpPort")
    public ConsultaRenapoPorCurp getConsultaRenapoPorCurpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.dgsei.edomex.gob.mx/", "ConsultaRenapoPorCurpPort"), ConsultaRenapoPorCurp.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONSULTARENAPOPORCURP_EXCEPTION!= null) {
            throw CONSULTARENAPOPORCURP_EXCEPTION;
        }
        return CONSULTARENAPOPORCURP_WSDL_LOCATION;
    }

}
