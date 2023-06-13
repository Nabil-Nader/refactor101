package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.dto.CustomerDto;
import com.refactor.code.dry.principle.model.Customer;
import com.refactor.code.dry.principle.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public CustomerDto getById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find customer"));
        return modelMapper.map(customer, CustomerDto.class);

    }

    @Override
    public CustomerDto create(CustomerDto entity) {
        Customer customer = modelMapper.map(entity, Customer.class);
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    @Override
    public CustomerDto update(Long aLong, CustomerDto entity) {
        Customer customer = customerRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Cannot find customer"));

        //update customer by entity or request
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);

    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
