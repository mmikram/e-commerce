package com.ghazitrader.ghazimart.service;

import java.util.ArrayList;
import java.util.List;

import com.ghazitrader.ghazimart.dao.AdminRepository;
import com.ghazitrader.ghazimart.model.AdminModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminModel saveOrUpdateAdmin(AdminModel adminModel) {
       return adminRepository.save(adminModel);
    }

    public List<AdminModel> getAllAdmin() {
        final List<AdminModel> admins = new ArrayList<AdminModel>();
        adminRepository.findAll().forEach(admin -> admins.add(admin));
        return admins;
    }

    public AdminModel getPerticularAdmin(final int userId) {
        return adminRepository.findById(userId).get();
    }

    public void adminStatus(final int userId, final int status) {
        final AdminModel adminModel = adminRepository.findById(userId).get();
        adminModel.setStatus(status);
        adminRepository.save(adminModel);
    }

    public boolean isMobileNumberExist(final String mobleNo) {
        if (null != getRecordByMobileNo(mobleNo)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmailExist(final String email) {
        if (null != getRecordByEmailId(email)) {
            return true;
        } else {
            return false;
        }
    }

    public AdminModel getRecordByMobileNo(final String mobleNo) {
        return adminRepository.findByMobleNo(mobleNo);
    }

    public AdminModel getRecordByEmailId(final String email) {
        return adminRepository.findByEmail(email);
    }

    public AdminModel adminLogin(final String mobileNo, final String password) {
        return adminRepository.findByMobleNoAndPassword(mobileNo, password);
    }

    public List<AdminModel> getParentAdmin(final int parentId) {
        return adminRepository.findByParentId(parentId);
    }

    public AdminModel updateAdmin(final int userId) {
        return adminRepository.findById(userId).get();
    }
}
