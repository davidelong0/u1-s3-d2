package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class GenericDAO {
    protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProvaJPA");

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        emf.close();
    }
}
