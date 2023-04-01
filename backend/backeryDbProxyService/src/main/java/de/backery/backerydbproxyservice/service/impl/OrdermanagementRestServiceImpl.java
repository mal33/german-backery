package de.backery.backerydbproxyservice.service.impl;

import de.backery.backerydbproxyservice.logic.Ordermanagement;
import de.backery.backerydbproxyservice.service.OrdermanagementRestService;
import de.backery.backerydbproxyservice.to.OrderTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class OrdermanagementRestServiceImpl implements OrdermanagementRestService {

    private final Ordermanagement ordermanagement;

    @Override
    public List<OrderTo> getAllOrders() {
        return ordermanagement.getAllOrders();
    }

    @Override
    public ResponseEntity<OrderTo> createOrder(OrderTo order) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordermanagement.createNewOrder(order));
    }

    @Override
    public ResponseEntity<OrderTo> getOrderById(String orderId) {
        OrderTo foundOrder = ordermanagement.getOrderById(orderId);
        return generateOrderToResponse(foundOrder);
    }

    @Override
    public ResponseEntity<OrderTo> updateOrder(String orderId, OrderTo order) {
        OrderTo updatedOrder = ordermanagement.updateOrder(order);
        return generateOrderToResponse(updatedOrder);
    }

    @Override
    public ResponseEntity<OrderTo> deleteOrder(String orderId) {
        OrderTo deletedOrder = ordermanagement.deleteOrder(orderId);
        return generateOrderToResponse(deletedOrder);
    }

    private ResponseEntity<OrderTo> generateOrderToResponse(OrderTo orderTo) {
        if (orderTo != null) {
            return ResponseEntity.ok(orderTo);
        }
        return ResponseEntity.notFound().build();
    }
}
