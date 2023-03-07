package com.example.controllers;

import com.example.models.Position;
import com.example.models.Post;
import com.example.services.PositionService;
import com.example.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PostService postService;
    @Autowired
    private PostController postController;


    @Test
    public void list() {

        List<Post> listKon = postController.list();
        assertEquals(2,listKon.size());

    }


    @Test
    public void add() {
        Post post = new Post();
        post.setTitle("post");
        post.setAnons("asdfghj");
        post.setKolvo(3);

        Post post1 = postController.add(post);

        assertEquals("post", post1.getTitle());


    }


    @Test
    public void delete() {
        String del = postController.deletePost(4);

        assertEquals("Post was deleted", del);


    }


    @Test
    public void edit() {
        Post post = new Post();
        post.setTitle("name");
        post.setAnons("hgfd");
        post.setKolvo(5);

        Post post1 = postController.updatePost(3, "name", "erftghj", 4);





        assertEquals("name",post1.getTitle());


    }

}
