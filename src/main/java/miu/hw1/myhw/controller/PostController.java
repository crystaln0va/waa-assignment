package miu.hw1.myhw.controller;

import miu.hw1.myhw.domain.dto.PostDto;
import miu.hw1.myhw.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/posts")
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable("id") int id) {
        return postService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PostDto postDto) {
        postService.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        postService.deleteById(id);
    }
}
