package miu.hw1.myhw.repo;

import miu.hw1.myhw.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo {

    // The database, abstract
    // Deals with plain old Java objects

    public List<Post> findAll();

    public Post findById(int id);

    public void save(Post post);

    public void deleteById(int id);
}
