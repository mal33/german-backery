package de.backery.backerydbproxyservice.service;

import de.backery.backerydbproxyservice.to.OrderTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public interface OrdermanagementRestService {

    @GetMapping("/orders")
    List<OrderTo> getAllOrders();

    @PostMapping("/orders")
    ResponseEntity<OrderTo> createOrder(@RequestBody OrderTo order);

    @GetMapping("/orders/{orderId}")
    ResponseEntity<OrderTo> getOrderById(@PathVariable(value = "orderId") String orderId);

    @PutMapping("/orders/{orderId}")
    ResponseEntity<OrderTo> updateOrder(@PathVariable(value = "orderId") String orderId,
                                            @RequestBody OrderTo order);

    @DeleteMapping("/orders/{orderId}")
    ResponseEntity<OrderTo> deleteOrder(@PathVariable(value = "orderId") String orderId);
}
