package com.refactor.code.dry.principle.controller.refactor;

import com.refactor.code.dry.principle.dto.UserDto;
import com.refactor.code.dry.principle.model.User;
import com.refactor.code.dry.principle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController extends CrudController<UserDto, Long> {

    // no need to repeat CRUD methods here

    private final UserService userService;

    @Override
    protected CrudService<UserDto, Long> getService() {
        return userService;
    }


}
