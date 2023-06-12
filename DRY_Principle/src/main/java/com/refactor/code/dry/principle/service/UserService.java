package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.controller.refactor.CrudService;
import com.refactor.code.dry.principle.model.Order;
import com.refactor.code.dry.principle.model.User;

public interface UserService extends CrudService<User,Long> {
}
