
package de.spqr.activitiderbysoapservice;

import de.spqr.activitiderbysoapservice.entity.BackWindow;
import de.spqr.activitiderbysoapservice.entity.Door;
import de.spqr.activitiderbysoapservice.entity.Engine;
import de.spqr.activitiderbysoapservice.entity.FrontWindow;
import de.spqr.activitiderbysoapservice.entity.Tire;
import de.spqr.activitiderbysoapservice.entity.Wheel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Class implements web service
 * 
 * @author said
 */
@WebService(endpointInterface = "de.spqr.activitiderbysoapservice.EntityServer")
public class EntityServerImpl implements EntityServer {

    public String getTimeAsString() {
        return new Date().toString();
    }

    public long getTimeAsElapsed() {
        return new Date().getTime();
    }

    /**
     * Checks number of parts in the database. Creates a string if there are not enough parts.
     * If there is no string to create, it starts method to reduce number of parts.
     * @return String with number of parts
     */
    public String orderParts() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<String> l1;

        ArrayList<String> list = new ArrayList<String>();
        Query q = em.createQuery("SELECT t FROM BackWindow t");
        @SuppressWarnings("unchecked")
        List<BackWindow> backwindow = q.getResultList();
        int counter = 0;
        if (backwindow.size() < 9) {
            Iterator it = backwindow.iterator();
            for (int i = 9; i >= 0; i--) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    counter++;
                }
            }
            while (counter > 0) {
                list.add("BackWindow ");
                counter--;
            }
        }


        q = em.createQuery("SELECT t FROM Door t");
        @SuppressWarnings("unchecked")
        List<Door> door = q.getResultList();
        counter = 0;
        if (door.size() < 9) {
            Iterator it = door.iterator();
            for (int i = 9; i >= 0; i--) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    counter++;
                }
            }
            while (counter > 0) {
                list.add("Door ");
                counter--;
            }
        }

        q = em.createQuery("SELECT t FROM Engine t");
        @SuppressWarnings("unchecked")
        List<Engine> engine = q.getResultList();
        counter = 0;
        if (engine.size() < 9) {
            Iterator it = engine.iterator();
            for (int i = 9; i >= 0; i--) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    counter++;
                }
            }
            while (counter > 0) {
                list.add("Engine ");
                counter--;
            }
        }


        q = em.createQuery("SELECT t FROM FrontWindow t");
        @SuppressWarnings("unchecked")
        List<FrontWindow> frontwindow = q.getResultList();
        counter = 0;
        if (frontwindow.size() < 9) {
            Iterator it = frontwindow.iterator();
            for (int i = 9; i >= 0; i--) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    counter++;
                }

            }
            while (counter > 0) {
                list.add("FrontWindow ");
                counter--;
            }
        }


        q = em.createQuery("SELECT t FROM Tire t");
        @SuppressWarnings("unchecked")
        List<Tire> tire = q.getResultList();
        counter = 0;
        if (tire.size() < 9) {
            Iterator it = tire.iterator();
            for (int i = 9; i >= 0; i--) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    counter++;
                }
            }
            while (counter > 0) {
                list.add("Tire ");
                counter--;
            }
        }



        q = em.createQuery("SELECT t FROM Wheel t");
        @SuppressWarnings("unchecked")
        List<Wheel> wheel = q.getResultList();
        counter = 0;
        if (wheel.size() < 9) {
            Iterator it = wheel.iterator();
            for (int i = 9; i >= 0; i--) {
                if (it.hasNext()) {
                    it.next();
                } else {
                    counter++;
                }

            }
            while (counter > 0) {
                list.add("Wheel ");
                counter--;
            }
        }

        em.getTransaction().commit();




        em.close();
        System.out.println(list);
        System.out.println(backwindow.size());
        System.out.println(door.size());
        System.out.println(engine.size());
        System.out.println(frontwindow.size());
        System.out.println(tire.size());
        System.out.println(wheel.size());

        String s = "";
        Iterator it = list.iterator();
        while (it.hasNext()) {
            s = s + it.next() + " /";
        }

        if (list.isEmpty()) {
            s = "Alle Teile vorhanden";
            try {
                lessParts();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return s;
    }

    /**
     * Method used to reduce the number of parts in the database.
     */
    private void lessParts() {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<String> l1;


        Query q = em.createQuery("SELECT t FROM BackWindow t");
        @SuppressWarnings("unchecked")
        List<BackWindow> backwindow = q.getResultList();

        Iterator it = backwindow.iterator();
        for (int i = 9; i >= 0; i--) {
            em.remove(it.next());
        }

        q = em.createQuery("SELECT t FROM Door t");
        @SuppressWarnings("unchecked")
        List<Door> door = q.getResultList();
        it = door.iterator();
        for (int i = 9; i >= 0; i--) {
            em.remove(it.next());
        }

        q = em.createQuery("SELECT t FROM Engine t");
        @SuppressWarnings("unchecked")
        List<Engine> engine = q.getResultList();
        it = engine.iterator();
        for (int i = 9; i >= 0; i--) {
            em.remove(it.next());
        }


        q = em.createQuery("SELECT t FROM FrontWindow t");
        @SuppressWarnings("unchecked")
        List<FrontWindow> frontwindow = q.getResultList();
        it = frontwindow.iterator();
        for (int i = 9; i >= 0; i--) {
            em.remove(it.next());
        }


        q = em.createQuery("SELECT t FROM Tire t");
        @SuppressWarnings("unchecked")
        List<Tire> tire = q.getResultList();
        it = tire.iterator();
        for (int i = 9; i >= 0; i--) {
            em.remove(it.next());
        }

        q = em.createQuery("SELECT t FROM Wheel t");
        @SuppressWarnings("unchecked")
        List<Wheel> wheel = q.getResultList();
        it = wheel.iterator();
        for (int i = 9; i >= 0; i--) {
            em.remove(it.next());
        }

        em.getTransaction()
                .commit();




        em.close();
    }
}