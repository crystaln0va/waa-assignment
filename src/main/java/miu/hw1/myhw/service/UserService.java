package miu.hw1.myhw.service;

import miu.hw1.myhw.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> findAll();

    public UserDto findById(int id);

    public void save(UserDto userDto);

    public void deleteById(int id);
}
