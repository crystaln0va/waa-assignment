package miu.hw1.myhw.service;

import miu.hw1.myhw.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto findById(int id);

    public void save(PostDto postDto);

    public void deleteById(int id);
}
