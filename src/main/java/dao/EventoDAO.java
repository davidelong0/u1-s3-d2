package dao;

import entities.*;
import jakarta.persistence.*;
import java.util.List;

public class EventoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProvaJPA");

    public void save(Evento evento) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Evento getById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Evento.class, id);
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Evento evento = em.find(Evento.class, id);
            if (evento != null) {
                em.remove(evento);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :streaming", Concerto.class)
                    .setParameter("streaming", inStreaming)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class)
                    .setParameter("genere", genere)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PartitaDiCalcio.vinteInCasa", PartitaDiCalcio.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("PartitaDiCalcio.vinteInTrasferta", PartitaDiCalcio.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }

}


