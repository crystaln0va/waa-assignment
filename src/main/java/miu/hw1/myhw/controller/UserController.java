package miu.hw1.myhw.controller;

import miu.hw1.myhw.domain.dto.PostDto;
import miu.hw1.myhw.domain.dto.UserDto;
import miu.hw1.myhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUserId(@PathVariable("id") int id) {
        userService.findById(id);
        return new ArrayList<PostDto>();
    }
}
