/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.spqr.activitiderbysoapservice;

import javax.jws.WebService;

/**
 * Class implements OrderService
 * @author said
 */

@WebService(endpointInterface = "de.spqr.activitiderbysoapservice.OrderServer")
public class OrderServerImpl implements OrderServer{

   
    /**
     * Sends order and checks if the class is correct
     * @param order order to check
     * @return correctness
     */
    @Override
    public boolean sendOrder(Order order) {
        return order.isCoorect();
    }
    
}
