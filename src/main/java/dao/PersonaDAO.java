package dao;

import entities.Persona;
import jakarta.persistence.EntityManager;

public class PersonaDAO extends GenericDAO {

    public void save(Persona persona) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Persona findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }
}
