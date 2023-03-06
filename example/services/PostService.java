package com.example.services;

import com.example.models.Position;
import com.example.models.Post;

import java.util.List;

public interface PostService {

    public Post savePost (Post post);
    public List<Post> getAllPosts();

    public void deleteById (Integer id);

    public Post get(Integer id);

}
