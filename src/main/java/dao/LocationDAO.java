package dao;

import entities.Location;
import jakarta.persistence.EntityManager;

public class LocationDAO extends GenericDAO {

    public void save(Location location) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Location findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Location.class, id);
        } finally {
            em.close();
        }
    }
}
