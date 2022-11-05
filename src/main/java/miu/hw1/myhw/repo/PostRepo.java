package miu.hw1.myhw.repo;

import miu.hw1.myhw.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post,Long> {

    // The database, abstract
    // Deals with plain old Java objects

    public List<Post> findAll();

    public Post findById(int id);

    public void deleteById(int id);
}
