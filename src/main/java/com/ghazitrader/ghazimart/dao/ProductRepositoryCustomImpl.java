package com.ghazitrader.ghazimart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ghazitrader.ghazimart.model.TempProduct;
import com.ghazitrader.ghazimart.model.TempProduct_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    @Autowired
    EntityManager em;

    @Override
    public List<TempProduct> search(String productName, String description, String productSearch) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TempProduct> criteriaQuery = builder.createQuery(TempProduct.class);
        Root<TempProduct> products = criteriaQuery.from(TempProduct.class);

        final Predicate productNamePredicate = builder.like(products.get(TempProduct_.PRODUCT_NAME),
                "%" + productName + "%");

        final Predicate descriptionPredicate = builder.like(products.get(TempProduct_.DESCRIPTION),
                "%" + description + "%");

        final Predicate productSearchPredicate = builder.like(products.get(TempProduct_.PRODUCT_SEARCH),
                "%" + productSearch + "%");
                
        final Predicate finalPredicate = builder.or(productNamePredicate, descriptionPredicate, productSearchPredicate);
        criteriaQuery.where(finalPredicate);

        final TypedQuery<TempProduct> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
