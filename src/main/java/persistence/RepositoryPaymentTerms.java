package persistence;

import model.PaymentTerms;
import util.DBUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryPaymentTerms {

    private EntityManager entityManager;

    public RepositoryPaymentTerms() {
        entityManager = DBUtil.getEntityManager();
    }

    public void savePaymentTerms(PaymentTerms paymentTerms) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(paymentTerms);
            entityManager.getTransaction().commit();
            System.out.println("Payment terms saved");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<PaymentTerms> listAllPaymentTerms() {
        List<PaymentTerms> list = null;
        try {
            list = entityManager
                    .createQuery("FROM PaymentTerms", PaymentTerms.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public PaymentTerms findPaymentTermsById (int paymentTermsId) {
        return entityManager.find(PaymentTerms.class, paymentTermsId);
    }
 }
