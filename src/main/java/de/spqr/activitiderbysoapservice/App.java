package de.spqr.activitiderbysoapservice;

import de.spqr.activitiderbysoapservice.entity.BackWindow;
import de.spqr.activitiderbysoapservice.entity.Door;
import de.spqr.activitiderbysoapservice.entity.Engine;
import de.spqr.activitiderbysoapservice.entity.FrontWindow;
import de.spqr.activitiderbysoapservice.entity.Tire;
import de.spqr.activitiderbysoapservice.entity.Wheel;
import java.util.Random;
import javax.persistence.*;
import javax.xml.ws.Endpoint;

/**
 * Class for initializing database and starting the web service
 * @author said
 *
 */
public class App {

    private static final String PERSISTENCE_UNIT_NAME = "de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU";

    public static void main(String[] args) {

        
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();


        //Creates random number of parts
        Random r = new Random();
        for (int j = r.nextInt(100) + 1; j > 0; j--) {
            em.persist((new BackWindow()));
        }
        for (int j = r.nextInt(100) + 1; j > 0; j--) {
            em.persist((new Door()));
        }
        for (int j = r.nextInt(100) + 1; j > 0; j--) {
            em.persist((new Engine()));
        }
        for (int j = r.nextInt(100) + 1; j > 0; j--) {
            em.persist((new FrontWindow()));
        }
        for (int j = r.nextInt(100) + 1; j > 0; j--) {
            em.persist((new Tire()));
        }
        for (int j = r.nextInt(100) + 1; j > 0; j--) {
            em.persist((new Wheel()));
        }

        em.getTransaction().commit();

        


        em.close();
        
        // Starts web service
        System.out.println("SOAP WS Endpoint listens ...");
        Endpoint.publish("http://localhost:9876/os", new OrderServerImpl());
        Endpoint.publish("http://localhost:9876/ps", new PartServer());
        

    }
}
