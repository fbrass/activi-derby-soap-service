/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.spqr.activitiderbysoapservice;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Interface für the order web service server
 * @author said
 */

@WebService(name = "OrderServer", targetNamespace="http://activitiderbysoapservice.spqr.de/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface OrderServer {
    @WebMethod @WebResult(partName = "return")boolean sendOrder(Order order);
    
}
