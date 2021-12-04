package persistence;

import model.Orders;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryOrders {

    private EntityManager entityManager;

    public RepositoryOrders() {
        entityManager = DBUtil.getEntityManager();
    }

    public void insertOrder (Orders orders) {
        entityManager.getTransaction().begin();
        entityManager.persist(orders);
        entityManager.getTransaction().commit();
        System.out.println("New order saved");
    }

    public List<Orders> listAllOrders() {
        return entityManager
                .createQuery("FROM Orders", Orders.class)
                .getResultList();
    }

    public Orders findOrderById (int ordersId) {
        return entityManager.find(Orders.class, ordersId);
    }

}
