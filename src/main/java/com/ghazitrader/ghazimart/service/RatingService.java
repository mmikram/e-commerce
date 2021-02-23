package com.ghazitrader.ghazimart.service;

import java.util.List;

import com.ghazitrader.ghazimart.dao.FavouriteRespository;
import com.ghazitrader.ghazimart.dao.RatingRepository;
import com.ghazitrader.ghazimart.model.Favourite;
import com.ghazitrader.ghazimart.model.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private FavouriteRespository favouriteRespository;

    @Autowired
    private RatingRepository ratingRepository;

    public void addFavourite(final Favourite favourite) {
        favouriteRespository.save(favourite);
    }
    

    public void addRating(final Rating rating) {
        ratingRepository.save(rating);
    }

    public List<Favourite> getFavProductIds(final int custId){
        return favouriteRespository.findByCustId(custId);
    }



}
