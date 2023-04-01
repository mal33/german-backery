package de.backery.backerydbproxyservice.logic.impl;

import de.backery.backerydbproxyservice.dataaccess.entity.OrderEntity;
import de.backery.backerydbproxyservice.mapper.CustomMapper;
import de.backery.backerydbproxyservice.to.OrderTo;
import de.backery.backerydbproxyservice.dataaccess.repo.OrderRepository;
import de.backery.backerydbproxyservice.logic.Ordermanagement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrdermanagementImpl implements Ordermanagement {

    private final CustomMapper customMapper;
    private final OrderRepository orderRepository;

    @Override
    public List<OrderTo> getAllOrders() {
        List<OrderEntity> allOrderEntity = orderRepository.findAll();
        log.info("Found {} orders", allOrderEntity.size());
        return customMapper.orderEntityListToOrderToList(allOrderEntity);
    }

    @Override
    public OrderTo createNewOrder(OrderTo orderTo) {
        OrderEntity convertedOrder = customMapper.orderToToOrderEntity(orderTo);
        convertedOrder.setOrderId(UUID.randomUUID().toString());
        OrderEntity savedOrder = orderRepository.saveAndFlush(convertedOrder);
        log.info("The order with id {} has been created", savedOrder.getOrderId());
        return customMapper.orderEntityToOrderTo(savedOrder);
    }

    @Override
    public OrderTo getOrderById(String orderId) {
        OrderEntity foundOrderEntity = orderRepository.findByOrderId(orderId);
        log.info("Found order with id {}", foundOrderEntity.getOrderId());
        return customMapper.orderEntityToOrderTo(foundOrderEntity);
    }

    @Override
    public OrderTo updateOrder(OrderTo reqOrderTo) {
        Optional<OrderTo> reqOrder = Optional.ofNullable(reqOrderTo);
        if (reqOrder.isPresent()) {
            OrderEntity foundOrderEntity =
                    orderRepository.findByOrderId(reqOrder.get().getOrderId());
            OrderEntity changedEntity = orderRepository.save(OrderEntity
                    .builder()
                    .id(foundOrderEntity.getId())
                    .orderId(foundOrderEntity.getOrderId())
                    .description(reqOrderTo.getDescription())
                    .build()
            );
            log.info("Order with id {} has been updated", changedEntity.getOrderId());
            return customMapper.orderEntityToOrderTo(changedEntity);
        }
        return null;
    }

    @Override
    public OrderTo deleteOrder(String orderId) {
        OrderEntity toBeDeletedOrder =
                orderRepository.findByOrderId(orderId);
        if (toBeDeletedOrder != null) {
            orderRepository.delete(toBeDeletedOrder);
            log.info("Order with id {} has been deleted", toBeDeletedOrder.getOrderId());
            return customMapper.orderEntityToOrderTo(toBeDeletedOrder);
        }
        return null;
    }
}
