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


    public AddressDetails saveAddress(final AddressDetails addressDetails){
       return addressRepository.save(addressDetails);
    }

    public AddressDetails defaultAddress(final String mobileNo){
        return addressRepository.defaultAddress(mobileNo);
     }

    public List<AddressDetails> custAddressByMobile(final String mobile){
        return addressRepository.findByMobile(mobile);
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
