package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.dto.OrderDto;
import com.refactor.code.dry.principle.model.Order;
import com.refactor.code.dry.principle.model.OrderStatus;
import com.refactor.code.dry.principle.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<OrderDto> getAll() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public OrderDto getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find Order"));
        return modelMapper.map(order, OrderDto.class);

    }

    @Override
    public OrderDto create(OrderDto entity) {
        Order order = modelMapper.map(entity, Order.class);
        return modelMapper.map(orderRepository.save(order), OrderDto.class);
    }

    @Override
    public OrderDto update(Long aLong, OrderDto entity) {
        Order order = orderRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Cannot find customer"));

        //update customer by entity or request
        return modelMapper.map(orderRepository.save(order), OrderDto.class);

    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> findOrderByOrderStatus(OrderStatus status) {
        List<Order> orderList = orderRepository.findOrderByOrderStatus(status);
        return orderList.stream().map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrderByDate(String sort) {
        List<Order> orderList;

        if (sort.equalsIgnoreCase("asc")) {
            orderList = orderRepository.findAllByOrderByDateAsc();
        } else {
            orderList = orderRepository.findAllByOrderByDateDesc();
        }


        return orderList.stream().map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }
}
