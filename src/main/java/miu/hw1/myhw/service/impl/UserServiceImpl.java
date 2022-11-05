package miu.hw1.myhw.service.impl;

import miu.hw1.myhw.domain.User;
import miu.hw1.myhw.domain.dto.UserDto;
import miu.hw1.myhw.repo.UserRepo;
import miu.hw1.myhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserDto> findAll() {
        var users = userRepo.findAll();
        return users
                .stream()
                .map(u -> new UserDto(u.getId(),u.getName(),u.getPosts()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(int id) {
        User user = userRepo.findById(id);
        return new UserDto(user.getId(),user.getName(),user.getPosts());
    }

    @Override
    public void save(UserDto userDto) {
        User user = new User(userDto.getId(),userDto.getName(),userDto.getPosts());
        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
}
