package com.parser.database;

import com.parser.database.entity.SystemChat;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public class ChatRepository {
    private EntityManager entityManager;

    public ChatRepository() {
        this.entityManager = DatabaseConnector
                .sessionFactory
                .createEntityManager();
    }

    public List<SystemChat> findAllChats() {
        return entityManager.createNativeQuery("SELECT * FROM chat").getResultList();
    }

    public List<SystemChat> getChatByChatId(Long chatId) {
        List<SystemChat> result =  entityManager.createQuery("SELECT c FROM SystemChat c WHERE c.chatId = :id").setParameter("id", chatId).getResultList();
        return result;
    }

    public List<SystemChat> getChatByToken(String token) {
        List<SystemChat> result = entityManager.createQuery("SELECT c FROM SystemChat c WHERE c.token = :token").setParameter("token", token).getResultList();
        return result;
    }

    public SystemChat saveChat(SystemChat systemChat) {
        entityManager.getTransaction().begin();
        entityManager.persist(systemChat);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return systemChat;
    }

    public void removeChat(SystemChat systemChat) {
        entityManager.getTransaction().begin();
        entityManager.remove(systemChat);
        entityManager.getTransaction().commit();
    }
}
