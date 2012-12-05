
package de.spqr.activitiderbysoapservice;


import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Interface for the car part web service server
 *
 * @author said
 */
@WebService(name = "EntityServer", targetNamespace="http://activitiderbysoapservice.spqr.de/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EntityServer {
    @WebMethod @WebResult(partName = "return")String getTimeAsString();
    @WebMethod @WebResult(partName = "return")long getTimeAsElapsed();
    @WebMethod @WebResult(partName = "return")long orderParts(String part);
    @WebMethod @WebResult(partName = "return")boolean changeBackWindowAmount(int amount);
    @WebMethod @WebResult(partName = "return")boolean changeDoorAmount(int amount);
    @WebMethod @WebResult(partName = "return")boolean changeFronWindowAmount(int amount);
    @WebMethod @WebResult(partName = "return")boolean changeEngineAmount(int amount);
    @WebMethod @WebResult(partName = "return")boolean changeTireAmount(int amount);
    @WebMethod @WebResult(partName = "return")boolean changeWheelAmount(int amount);
    @WebMethod @WebResult(partName = "return")long amountOfParts(String part);
    
}