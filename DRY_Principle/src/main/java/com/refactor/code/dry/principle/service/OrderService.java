package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.controller.refactor.CrudService;
import com.refactor.code.dry.principle.dto.OrderDto;
import com.refactor.code.dry.principle.model.OrderStatus;

import java.util.List;

public interface OrderService extends CrudService<OrderDto, Long> {
    List<OrderDto> findOrderByOrderStatus(OrderStatus status);

    List<OrderDto> getOrderByDate(String sort);
}
