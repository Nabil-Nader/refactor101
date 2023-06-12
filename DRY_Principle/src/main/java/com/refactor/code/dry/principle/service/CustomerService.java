package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.controller.refactor.CrudService;
import com.refactor.code.dry.principle.model.Customer;

public interface CustomerService extends CrudService<Customer,Long> {
    //sine this is an interface, we can extend as much as we want, and also have customer own method
}
