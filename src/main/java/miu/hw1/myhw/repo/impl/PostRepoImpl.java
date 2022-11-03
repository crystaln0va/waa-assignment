package miu.hw1.myhw.repo.impl;

import miu.hw1.myhw.domain.Post;
import miu.hw1.myhw.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    // The database, implemented

    private static List<Post> posts;
    private static int postId = 300;

    static {
        posts = new ArrayList<>();

        Post p1 = new Post(255l,"New blog","Starting a blog","Flo");
        Post p2 = new Post(260l,"Halloween","A great holiday","Fire");
        Post p3 = new Post(265l,"Christmas","A popular holiday","Christ");
        Post p4 = new Post(270l,"Africa","A large continent","Blacks");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postId++);
        posts.add(post);
    }

    @Override
    public void deleteById(int id) {
        var post = posts
                .stream()
                .filter(p-> p.getId()==id)
                .findFirst()
                .get();
        posts.remove(post);
    }
}
