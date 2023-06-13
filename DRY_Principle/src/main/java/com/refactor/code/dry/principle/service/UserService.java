package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.controller.refactor.CrudService;
import com.refactor.code.dry.principle.dto.UserDto;

public interface UserService extends CrudService<UserDto, Long> {
}
