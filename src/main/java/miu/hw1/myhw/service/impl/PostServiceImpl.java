package miu.hw1.myhw.service.impl;

import miu.hw1.myhw.domain.Post;
import miu.hw1.myhw.domain.dto.PostDto;
import miu.hw1.myhw.repo.PostRepo;
import miu.hw1.myhw.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Override
    public List<PostDto> findAll() {
        var posts = postRepo.findAll();
        return posts
                .stream()
                .map(p -> new PostDto(p.getId(),p.getTitle(),p.getContent(),p.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {
        var post = postRepo.findById(id);
        return new PostDto(post.getId(),post.getTitle(),post.getContent(),post.getAuthor());
    }

    @Override
    public void save(PostDto postDto) {
        Post post = new Post(postDto.getId(),postDto.getTitle(),postDto.getAuthor(),postDto.getAuthor());
        postRepo.save(post);
    }

    @Override
    public void deleteById(int id) {
        postRepo.deleteById(id);
    }
}
