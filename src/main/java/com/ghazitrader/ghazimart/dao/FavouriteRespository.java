package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.Favourite;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRespository extends CrudRepository<Favourite,Integer> {
    @Query(value = "select productId favourite f where f.custId=:custId", nativeQuery = true)
    public List<Favourite> findByCustId(final int custId);
}
