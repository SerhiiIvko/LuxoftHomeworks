package com.luxoft.ivko.dao.impl;

import com.luxoft.ivko.appProperties.ConstantsContainer;
import com.luxoft.ivko.dao.ProductDao;
import com.luxoft.ivko.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@EnableTransactionManagement
public class ProductDaoDBImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductDaoDBImpl() {
    }

    @Override
    public Product getProductById(Long id) {
        TypedQuery<Product> query = entityManager.createQuery(ConstantsContainer.PRODUCT_BY_ID, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void saveProduct(Product entity) {
        entityManager.persist(entity);
    }

    @Override
    public Product updateProduct(Product entity) {
        return entityManager.merge(entity);
    }

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery(ConstantsContainer.PRODUCTS_AS_LIST, Product.class);
        return query.getResultList();
    }


    public void removeProduct(Long id) {
        Product entity = entityManager.getReference(Product.class, id);
        entityManager.remove(entity);
    }
}
