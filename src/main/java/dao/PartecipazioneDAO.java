package dao;

import entities.Partecipazione;
import jakarta.persistence.EntityManager;

public class PartecipazioneDAO extends GenericDAO {

    public void save(Partecipazione partecipazione) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(partecipazione);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Partecipazione findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Partecipazione.class, id);
        } finally {
            em.close();
        }
    }
}

