package com.ghazitrader.ghazimart.service;

import java.util.List;

import com.ghazitrader.ghazimart.dao.AddToCardRepository;
import com.ghazitrader.ghazimart.dao.OrderRepository;
import com.ghazitrader.ghazimart.dao.TempOrderRepository;
import com.ghazitrader.ghazimart.model.AddToCard;
import com.ghazitrader.ghazimart.model.OrderDetails;
import com.ghazitrader.ghazimart.model.TempOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public AddToCardRepository addToCardRepository;

    @Autowired
    public TempOrderRepository tempOrderRepository;

    public void saveOrder(final OrderDetails details) {
        orderRepository.save(details);
    }

    public List<OrderDetails> custOrder(final int custId) {
        return orderRepository.findByCustId(custId);
    }

    /**
     * Temp Order
     */

    public void saveTempOrder(final TempOrder entity) {
       final String mobileNo= tempOrderRepository.save(entity).getCustMobile();
       if (null!=mobileNo) {
           addToCardRepository.deleteByMobileNo(mobileNo);
       }
    }

    public List<TempOrder> activeTempOrder(final int status,final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tempOrderRepository.findByStatus(status,pageable);
    }

    public List<TempOrder> customerTempOrders(final String custMobile,final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tempOrderRepository.findByCustMobile(custMobile,pageable);
    }

    public int addToCart(final AddToCard addToCard){
       return addToCardRepository.save(addToCard).getId();
    }

    public List<AddToCard> getCartItem(final String mobile){
        return addToCardRepository.findByMobileNo(mobile);
    }

    public void removeSingleCartItem(final AddToCard addToCard){
        addToCardRepository.delete(addToCard);
    }

    public int getTotalNumberOfCard(final String mobile){
       return addToCardRepository.totalCart(mobile);
    }

    public void updateOrderStatus(final int orderId,final int status){
        tempOrderRepository.orderStatus(orderId, status);
    }


}
