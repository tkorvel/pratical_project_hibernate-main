package persistence;

import model.Product;
import util.DBUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryProduct {

        private EntityManager entityManager;

        public RepositoryProduct() {
            entityManager = DBUtil.getEntityManager();
        }

        public void saveProduct(Product product) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(product);
                entityManager.getTransaction().commit();
                System.out.println("Product saved");
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        }

        public List<Product> listAllProducts() {
            return entityManager
                    .createQuery("FROM Product", Product.class)
                    .getResultList();
        }

        public Product findProductById (int productId) {
            return entityManager.find(Product.class, productId);
        }

        public void updateNowInStock(int productId, int nowInStock) {
            String sql = "UPDATE Product pro SET pro.nowInStock =: newNowInStock WHERE pro.productId = :id";
            entityManager.getTransaction().begin();
            entityManager
                    .createQuery(sql)
                    .setParameter("newNowInStock", nowInStock)
                    .setParameter("id", productId)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            System.out.println("Product quantity updated");
        }

}
