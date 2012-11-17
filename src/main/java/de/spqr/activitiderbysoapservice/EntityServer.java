
package de.spqr.activitiderbysoapservice;


import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Interface for the web service server
 *
 * @author said
 */
@WebService(name = "EntityServer", targetNamespace="http://activitiderbysoapservice.spqr.de/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EntityServer {
    @WebMethod @WebResult(partName = "return")String getTimeAsString();
    @WebMethod @WebResult(partName = "return")long getTimeAsElapsed();
    @WebMethod @WebResult(partName = "return")String orderParts();
    
}