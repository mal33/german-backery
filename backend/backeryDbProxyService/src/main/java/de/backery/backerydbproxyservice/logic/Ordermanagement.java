package de.backery.backerydbproxyservice.logic;


import de.backery.backerydbproxyservice.to.OrderTo;

import java.util.List;

public interface Ordermanagement {

    List<OrderTo> getAllOrders();
}
