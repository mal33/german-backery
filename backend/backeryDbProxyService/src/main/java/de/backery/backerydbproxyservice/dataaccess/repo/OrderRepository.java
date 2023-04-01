package de.backery.backerydbproxyservice.dataaccess.repo;

import de.backery.backerydbproxyservice.dataaccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    OrderEntity findByOrderId(String orderId);
}
