package com.refactor.code.dry.principle.repository;

import com.refactor.code.dry.principle.model.Order;
import com.refactor.code.dry.principle.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByOrderStatus(OrderStatus orderStatus);

    List<Order> findAllByOrderByDateAsc();
    List<Order> findAllByOrderByDateDesc();

}
