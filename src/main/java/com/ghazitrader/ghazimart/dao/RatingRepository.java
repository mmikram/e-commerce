package com.ghazitrader.ghazimart.dao;

import com.ghazitrader.ghazimart.model.Rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

}
