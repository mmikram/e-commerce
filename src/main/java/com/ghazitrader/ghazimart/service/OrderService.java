package com.ghazitrader.ghazimart.service;

import java.util.List;

import com.ghazitrader.ghazimart.dao.OrderRepository;
import com.ghazitrader.ghazimart.dao.TempOrderRepository;
import com.ghazitrader.ghazimart.model.OrderDetails;
import com.ghazitrader.ghazimart.model.TempOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

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
        tempOrderRepository.save(entity);
    }

    public List<TempOrder> activeTempOrder(){
        return tempOrderRepository.tempOrders();
    }


}
