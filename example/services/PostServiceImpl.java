package com.example.services;

import com.example.models.Post;
import com.example.repo.PositionRepo;
import com.example.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;
    @Override
    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        postRepo.deleteById(id);

    }

    @Override
    public Post get(Integer id) {
        return postRepo.findById(id).get();
    }
}
