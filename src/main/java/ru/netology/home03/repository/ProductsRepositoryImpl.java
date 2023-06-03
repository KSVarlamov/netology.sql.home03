package ru.netology.home03.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepositoryImpl implements ProductsRepository {


    @PersistenceContext
    EntityManager manager;

    public ProductsRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List getProductName(String userName) {
        var query = manager.createQuery("select productName from Order o where o.customer.name = :userName");
        query.setParameter("userName", userName);
        return query.getResultList();
    }
}
