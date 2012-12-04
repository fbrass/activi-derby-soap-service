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
public class PartServer implements EntityServer{

    @Override
    public String getTimeAsString() {
        return new Date().toString();
    }

    @Override
    public long getTimeAsElapsed() {
        return new Date().getTime();
    }

    /**
     * Checks amount of parts thats given in the string. If amount is less than
     * ten, returns needed amount of parts.
     *
     * @param part Name of Part to check
     * @return int number of needed parts
     */
    @Override
    public long orderParts(String part) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("SELECT t FROM " + part + " t");
        @SuppressWarnings("unchecked")
        List parts = q.getResultList();
        em.getTransaction().commit();
        em.close();
        if (parts.size() < 9) {
            return 9 - parts.size();

        } else {
            return 0;
        }
    }
    
    /**
     * Methode used to change the amount of backWindows in the DB
     * @param amount new amount
     * @return 
     */
    @Override
    public boolean changeBackWindowAmount( int amount) {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM BackWindow t");
            @SuppressWarnings("unchecked")
            List<BackWindow> backwindow = q.getResultList();
            int dif;
            if (backwindow.size() + 1 < amount) {
                dif = amount - (backwindow.size() + 1);
                for (int i = 0; i < dif; i++) {
                    em.persist(new BackWindow());
                }
            }
            if (backwindow.size() + 1 > amount) {
                dif = (backwindow.size() + 1) - amount;
                for (int i = 0; i < dif; i++) {
                    em.remove(backwindow.get(i));
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method used to change the amount of doors in the DB
     * @param amount new amount
     * @return 
     */
    @Override
    public boolean changeDoorAmount( int amount) {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM Door t");
            @SuppressWarnings("unchecked")
            List<Door> door = q.getResultList();
            int dif;
            if (door.size() + 1 < amount) {
                dif = amount - (door.size() + 1);
                for (int i = 0; i < dif; i++) {
                    em.persist(new Door());
                }
            }
            if (door.size() + 1 > amount) {
                dif = (door.size() + 1) - amount;
                for (int i = 0; i < dif; i++) {
                    em.remove(door.get(i));
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method used to change the amount of frontwindows in the DB
     * @param amount new amount
     * @return 
     */
    @Override
    public boolean changeFronWindowAmount( int amount) {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM Door t");
            @SuppressWarnings("unchecked")
            List<FrontWindow> frontWindow = q.getResultList();
            int dif;
            if (frontWindow.size() + 1 < amount) {
                dif = amount - (frontWindow.size() + 1);
                for (int i = 0; i < dif; i++) {
                    em.persist(new FrontWindow());
                }
            }
            if (frontWindow.size() + 1 > amount) {
                dif = (frontWindow.size() + 1) - amount;
                for (int i = 0; i < dif; i++) {
                    em.remove(frontWindow.get(i));
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method used to change the amount of engines in the DB
     * @param amount new amount
     * @return 
     */
    @Override
    public boolean changeEngineAmount( int amount) {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM Door t");
            @SuppressWarnings("unchecked")
            List<Engine> engine = q.getResultList();
            int dif;
            if (engine.size() + 1 < amount) {
                dif = amount - (engine.size() + 1);
                for (int i = 0; i < dif; i++) {
                    em.persist(new Engine());
                }
            }
            if (engine.size() + 1 > amount) {
                dif = (engine.size() + 1) - amount;
                for (int i = 0; i < dif; i++) {
                    em.remove(engine.get(i));
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method used to change the amount of tires in the DB
     * @param amount new amount
     * @return 
     */
    @Override
    public boolean changeTireAmount( int amount) {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM Door t");
            @SuppressWarnings("unchecked")
            List<Tire> tire = q.getResultList();
            int dif;
            if (tire.size() + 1 < amount) {
                dif = amount - (tire.size() + 1);
                for (int i = 0; i < dif; i++) {
                    em.persist(new Tire());
                }
            }
            if (tire.size() + 1 > amount) {
                dif = (tire.size() + 1) - amount;
                for (int i = 0; i < dif; i++) {
                    em.remove(tire.get(i));
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method used to change the amount of wheels in the DB
     * @param amount new amount
     * @return 
     */
    @Override
    public boolean changeWheelAmount( int amount) {
        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM Door t");
            @SuppressWarnings("unchecked")
            List<Wheel> wheel = q.getResultList();
            int dif;
            if (wheel.size() + 1 < amount) {
                dif = amount - (wheel.size() + 1);
                for (int i = 0; i < dif; i++) {
                    em.persist(new Wheel());
                }
            }
            if (wheel.size() + 1 > amount) {
                dif = (wheel.size() + 1) - amount;
                for (int i = 0; i < dif; i++) {
                    em.remove(wheel.get(i));
                }
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method used to get the amount of one part in the DB
     * @param part
     * @return 
     */
    @Override
    public long amountOfParts(String part) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("de.spqr_activiti-derby-soap-service_jar_1.0-SNAPSHOTPU");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        Query q = em.createQuery("SELECT t FROM " + part + " t");
        @SuppressWarnings("unchecked")
        List parts = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return parts.size()+1;
    }
}