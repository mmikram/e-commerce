package com.ghazitrader.ghazimart.service;

import java.util.List;

import com.ghazitrader.ghazimart.dao.AddressRepository;
import com.ghazitrader.ghazimart.dao.AddressStoreRepository;
import com.ghazitrader.ghazimart.model.AddressDetails;
import com.ghazitrader.ghazimart.model.AddressStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressStoreRepository addressStoreRepository;


    public void saveAddress(final AddressDetails addressDetails){
        addressRepository.save(addressDetails);
    }

    public List<AddressDetails> custAddress(final int custId){
        return addressRepository.findByCustId(custId);
    }

    public AddressStore saveStoreAddress(final AddressStore entity){
       return addressStoreRepository.save(entity);
    }

    public AddressStore storeAddressByMobileNo(final String mobileNo){
        return addressStoreRepository.findByMobileNo(mobileNo);
    }

    public AddressStore storeAddressByCustName(final String custName){
        return addressStoreRepository.findByCustName(custName);
    }
   
}
