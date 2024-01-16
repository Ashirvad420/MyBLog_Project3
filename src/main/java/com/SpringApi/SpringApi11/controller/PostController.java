package com.SpringApi.SpringApi11.controller;

import com.SpringApi.SpringApi11.entity.Post;
import com.SpringApi.SpringApi11.payload.PostDto;
import com.SpringApi.SpringApi11.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService; // this is interface this is parent of PostServiceImpl

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Post Mapping
    @PostMapping
    public ResponseEntity<PostDto> createDto(@RequestBody PostDto postDto) // this is method
    {
    PostDto dto=postService.createPost(postDto);
    return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //create post base on post id

    // http://localhost:8080/api/posts/all?id=1

    @GetMapping("/all")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id)
    {
      PostDto dto = postService.getPostById(id);
      return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    // How to read all the data from database

    @GetMapping
    public List<PostDto> getAllPost()
    {
        List<PostDto> postDtos =postService.getAllPost();
        return postDtos;
    }

}


// return type of public method is RequestEntity
// @RequestBody :- it takes the json object
// PostDto :- PostDto use to custom response can send back to the service