package com.ghazitrader.ghazimart.dao;

import java.util.List;

import com.ghazitrader.ghazimart.model.AdminModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends CrudRepository<AdminModel, Integer>{
    public AdminModel findByMobleNo(final String mobleNo);
    public AdminModel findByEmail(final String email);
    public List<AdminModel> findByParentId(final int parentId);
    public AdminModel findByMobleNoAndPassword(@Param("mobileNo") String mobleNo,@Param("password") String password);
}