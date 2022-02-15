package com.parser.database;

import com.parser.database.entity.SystemChat;
import com.parser.database.entity.UsedToken;

import javax.persistence.EntityManager;
import java.util.List;

public class UsedTokenRepository {
    private EntityManager entityManager;

    public UsedTokenRepository() {
        this.entityManager = DatabaseConnector
                .sessionFactory
                .createEntityManager();
    }

    public Boolean checkToken(String token) {
        List<SystemChat> result = entityManager.createQuery("SELECT t FROM UsedToken t WHERE t.token = :token").setParameter("token", token).getResultList();

        return result.size() != 0;
    }

    public void saveToken(UsedToken token) {
        entityManager.getTransaction().begin();
        entityManager.persist(token);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }
}
