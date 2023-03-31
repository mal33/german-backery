package de.backery.backerydbproxyservice.logic.impl;

import de.backery.backerydbproxyservice.to.OrderTo;
import de.backery.backerydbproxyservice.dataaccess.repo.OrderRepository;
import de.backery.backerydbproxyservice.logic.Ordermanagement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrdermanagementImpl implements Ordermanagement {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderTo> getAllOrders() {
        return null;
    }
}
