package de.backery.backerydbproxyservice.logic;

import de.backery.backerydbproxyservice.to.OrderTo;

import java.util.List;

public interface Ordermanagement {

    List<OrderTo> getAllOrders();
    OrderTo createNewOrder(OrderTo orderTo);
    OrderTo getOrderById(String orderId);
    OrderTo updateOrder(OrderTo reqOrderTo);
    OrderTo deleteOrder(String orderId);
}
