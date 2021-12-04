package persistence;

import model.Address;
import model.Company;
import util.DBUtil;
import javax.persistence.EntityManager;
import java.util.List;

public class RepositoryCompany {

    private EntityManager entityManager;

    public RepositoryCompany() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveCompany(Company company) {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
            System.out.println("Company saved");
        }

    public void insertAddress (Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        System.out.println("Address saved");

    }

    public List<Company> listAllCompanies() {
        return  entityManager
                .createQuery("FROM Company" , Company.class)
                .getResultList();
    }

    public Company findCompanyById (int companyId) {
        return entityManager.find(Company.class, companyId);
        }

    public List<Address> findCompanyAddressesByCity (String city) {
        String sql = "FROM Address Where city =: ct";
        return entityManager
                .createQuery(sql, Address.class)
                .setParameter("ct",city)
                .getResultList();
    }

    public Company findCompanyByRegistryCode(int registryCode) {
         String sql = "FROM Company WHERE registryCode =: code";
         return entityManager
                 .createQuery(sql, Company.class)
                 .setParameter("code", registryCode)
                 .getSingleResult();
        }

    public List<Address> findCompanyAddressesByPostalCode (String postalCode) {
        String sql = "FROM Address Where postalCode =: pCode";
        return entityManager
                .createQuery(sql, Address.class)
                .setParameter("pCode",postalCode)
                .getResultList();
    }

    public void updateCompanyPhoneNumber(int companyId, String phoneNumber) {
        String sql = "UPDATE Company co SET co.phoneNumber = :newPhoneNumber WHERE co.companyId = :id";
        entityManager.getTransaction().begin();
        entityManager
                .createQuery(sql)
                .setParameter("newPhoneNumber", phoneNumber)
                .setParameter("id", companyId)
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println("Company phone number updated");
    }

    public void updateCompanyCreditRating (int companyId, int creditRating) {
        String sql = "UPDATE Company co SET co.creditRating =:newCreditRating WHERE co.companyId = :id";
        entityManager.getTransaction().begin();
        entityManager
                .createQuery(sql)
                .setParameter("newCreditRating", creditRating)
                .setParameter("id", companyId)
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println("Company credit rating updated");
    }
//    ?????????????????????
//    public void deleteCompany(int companyId) {
//            entityManager.getTransaction().begin();
//            entityManager.remove(entityManager.merge(companyId));
//            entityManager.getTransaction().commit();
//        System.out.println("Company deleted");
//        }
}

