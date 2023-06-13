package com.refactor.code.dry.principle.service;

import com.refactor.code.dry.principle.dto.UserDto;
import com.refactor.code.dry.principle.model.User;
import com.refactor.code.dry.principle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(customer -> modelMapper.map(customer, UserDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find user"));
        return modelMapper.map(user, UserDto.class);

    }

    @Override
    public UserDto create(UserDto entity) {
        User user = modelMapper.map(entity, User.class);
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto update(Long aLong, UserDto entity) {
        User order = userRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Cannot find customer"));

        //update customer by entity or request
        return modelMapper.map(userRepository.save(order), UserDto.class);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
