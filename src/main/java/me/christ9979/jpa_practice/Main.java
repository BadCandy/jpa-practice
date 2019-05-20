package me.christ9979.jpa_practice;

import me.christ9979.jpa_practice.entity.Delivery;
import me.christ9979.jpa_practice.entity.Order;
import me.christ9979.jpa_practice.entity.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Delivery delivery = new Delivery();
            OrderItem orderItem1 = new OrderItem();
            OrderItem orderItem2 = new OrderItem();

            Order order = new Order();
            order.setDelivery(delivery);
            order.addOrderItem(orderItem1);
            order.addOrderItem(orderItem2);
            entityManager.persist(order);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        factory.close();
    }
}
