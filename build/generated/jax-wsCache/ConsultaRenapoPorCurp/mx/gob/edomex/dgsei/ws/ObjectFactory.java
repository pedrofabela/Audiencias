
package mx.gob.edomex.dgsei.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mx.gob.edomex.dgsei.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultaPorCurpResponse_QNAME = new QName("http://ws.dgsei.edomex.gob.mx/", "consultaPorCurpResponse");
    private final static QName _ConsultaPorCurp_QNAME = new QName("http://ws.dgsei.edomex.gob.mx/", "consultaPorCurp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.gob.edomex.dgsei.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaPorCurpResponse }
     * 
     */
    public ConsultaPorCurpResponse createConsultaPorCurpResponse() {
        return new ConsultaPorCurpResponse();
    }

    /**
     * Create an instance of {@link ConsultaPorCurp }
     * 
     */
    public ConsultaPorCurp createConsultaPorCurp() {
        return new ConsultaPorCurp();
    }

    /**
     * Create an instance of {@link PersonasDTO }
     * 
     */
    public PersonasDTO createPersonasDTO() {
        return new PersonasDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaPorCurpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.dgsei.edomex.gob.mx/", name = "consultaPorCurpResponse")
    public JAXBElement<ConsultaPorCurpResponse> createConsultaPorCurpResponse(ConsultaPorCurpResponse value) {
        return new JAXBElement<ConsultaPorCurpResponse>(_ConsultaPorCurpResponse_QNAME, ConsultaPorCurpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaPorCurp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.dgsei.edomex.gob.mx/", name = "consultaPorCurp")
    public JAXBElement<ConsultaPorCurp> createConsultaPorCurp(ConsultaPorCurp value) {
        return new JAXBElement<ConsultaPorCurp>(_ConsultaPorCurp_QNAME, ConsultaPorCurp.class, null, value);
    }

}
