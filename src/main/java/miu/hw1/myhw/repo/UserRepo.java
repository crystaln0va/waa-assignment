package miu.hw1.myhw.repo;

import miu.hw1.myhw.domain.Post;
import miu.hw1.myhw.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Long> {

    public List<User> findAll();

    public User findById(int id);

    public void deleteById(int id);

    public List<Post> findPostByUserId(int id);
}