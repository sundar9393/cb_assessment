package app.login.service.dao;

import app.login.service.entity.Consumer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class ConsumerDao {

    @PersistenceContext
    private EntityManager entityManager;

    //Write a method to fetch user using phone number
    /*
    returns user if present else returns null
     */
    public Consumer fetchUserByPhone(String phoneNumber) {
        try {
            Consumer consumer = entityManager.createNamedQuery("consumerByContactNumber", Consumer.class).setParameter("contactNumber", phoneNumber).getSingleResult();
            return consumer;
        } catch (NoResultException nre) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Consumer addUser(Consumer newConsumer) {
        entityManager.persist(newConsumer);
        return newConsumer;
    }
}
