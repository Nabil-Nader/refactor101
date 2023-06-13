package com.refactor.code.dry.principle.controller.refactor;

import com.refactor.code.dry.principle.dto.OrderDto;
import com.refactor.code.dry.principle.model.OrderStatus;
import com.refactor.code.dry.principle.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController extends CrudController<OrderDto, Long> {


    private final OrderService orderService;

    @Override
    protected CrudService<OrderDto, Long> getService() {
        return orderService;
    }

    @GetMapping("/order/{status}")
    public List<OrderDto> getOrdersByStatus(@PathVariable("status") OrderStatus status) {
        return orderService.findOrderByOrderStatus(status);
    }

    @GetMapping("/date")
    public List<OrderDto> getOrdersByDate(@RequestParam("sort") String sort) {
        return orderService.getOrderByDate(sort);
    }
}
