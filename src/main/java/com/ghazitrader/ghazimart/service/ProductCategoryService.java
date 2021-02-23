package com.ghazitrader.ghazimart.service;

import java.util.ArrayList;
import java.util.List;

import com.ghazitrader.ghazimart.dao.ProductCategoryRepository;
import com.ghazitrader.ghazimart.dao.SubCategoryRepository;
import com.ghazitrader.ghazimart.model.ProductCategory;
import com.ghazitrader.ghazimart.model.SubCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    @Autowired
    public ProductCategoryRepository productCategoryRepository;

    @Autowired
    public SubCategoryRepository subCategoryRepository;

    public ProductCategory save(final ProductCategory category ){
       return productCategoryRepository.save(category);
    }

    public List<ProductCategory> getAllCatergory(){
        final List<ProductCategory> categories = new ArrayList<ProductCategory>();
        productCategoryRepository.findAll().forEach(category -> categories.add(category));
        return categories;
    }

    public void categoryStatus(final int catId, final int status){
        final ProductCategory category= productCategoryRepository.findById(catId).get();
        category.setStatus(status);
        productCategoryRepository.save(category);
    }

    public List<ProductCategory> getRandomCategory(){
        return productCategoryRepository.findRandonCategory();
    }

    public SubCategory saveSubCategory(final SubCategory category ){
       return subCategoryRepository.save(category);
    }

    public List<SubCategory> getAllSubCategory(){
        final List<SubCategory> categories = new ArrayList<SubCategory>();
        subCategoryRepository.findAll().forEach(category -> categories.add(category));
        return categories;
    }

    public void subCategoryStatus(final int subCatId, final int status){
        final SubCategory category= subCategoryRepository.findById(subCatId).get();
        category.setStatus(status);
        subCategoryRepository.save(category);
    }

    public List<SubCategory> getSlidItem(){
        return subCategoryRepository.findByIsForSlid(true);
    }

    public List<SubCategory> getSubCatByCatId(final int catId){
        return subCategoryRepository.getByCatId(catId);
    }

    public void updatSubCatBanner(final int subCatId, final String banner){
        final SubCategory category= subCategoryRepository.findById(subCatId).get();
        category.setBanner(banner);
        subCategoryRepository.save(category);
    }

    public void  updatCatBanner(final int catId, final String banner){
        final ProductCategory category= productCategoryRepository.findById(catId).get();
        category.setBanner(banner);
        productCategoryRepository.save(category);
    }

    public List<Integer> getSubCatIds(final int catId){
        return subCategoryRepository.findByCatIds(catId);
    }


    public void removeOfferProductBySubCat(final int subCatId){
        subCategoryRepository.deleteOfferItem(subCatId);
    }
   
}
