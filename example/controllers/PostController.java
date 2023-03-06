package com.example.controllers;

import com.example.models.Position;
import com.example.models.Post;
import com.example.services.PositionService;
import com.example.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/add")
    public Post add (@RequestBody Post post) {
        postService.savePost(post);
        return post;
    }
    @GetMapping("/getAll")
    public List<Post> list(){
        return postService.getAllPosts();
    }

    @GetMapping ("/delete/{id}")
    public String deletePost (@PathVariable(name = "id") Integer id) {
        postService.deleteById(id);
        return "Post was deleted";
    }

//    @GetMapping ("/calculate/{id}")
//    public double calculateSalary (@PathVariable(name = "id") Integer id) {
//        Position position = positionService.get(id);
//        double salary = position.getSalary();
//        return salary * 1.13;
//    }

    @PostMapping ("/edit/{id}")
    public Post updatePost (@PathVariable (name = "id") Integer id, @RequestParam String title, String anons, int kolvo, Model model) {
        Post post = postService.get(id);
        post.setTitle(title);
        post.setAnons(anons);
        post.setKolvo(kolvo);
        postService.savePost(post);

        return post;
    }

}
