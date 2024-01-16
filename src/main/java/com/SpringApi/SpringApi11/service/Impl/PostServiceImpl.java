package com.SpringApi.SpringApi11.service.Impl;
import com.SpringApi.SpringApi11.entity.Post;
import com.SpringApi.SpringApi11.exception.ResourceNotFoundException;
import com.SpringApi.SpringApi11.payload.PostDto;
import com.SpringApi.SpringApi11.repository.PostRepository;
import com.SpringApi.SpringApi11.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService { // here we call the PostService

    private PostRepository postRepository;  // here we will call repository interface

   // it can create generated constructor Base Dependency
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

        Post post = mapToEntity(postDto);

        Post savedPost= postRepository.save(post);  // To save Data using  postRepository


        PostDto dto = new PostDto(); // Return PostDto
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());

        PostDto dto1 =mapToDto(savedPost);

        return dto1;
    }


    // this is for getPostById
    @Override
    public PostDto getPostById(long id) {

       Post post = postRepository.findById(id).orElseThrow( //supplier
               ()->new ResourceNotFoundException("Post Not found with id:-"+id)
        );
        // Convert Post Object to dto

        PostDto dto = new PostDto(); // Return PostDto
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    // this is for Get All the data from database
    @Override
    public List<PostDto> getAllPost() {

        List<Post> posts = postRepository.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }

   PostDto mapToDto(Post post)  // return PostDto
   {
       PostDto dto = new PostDto(); // Return PostDto
       dto.setId(post.getId());
       dto.setTitle(post.getTitle());
       dto.setDescription(post.getDescription());
       dto.setContent(post.getContent());
       return  dto;
   }

    Post mapToEntity(PostDto postDto)  // return PostDto
    {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

}

// write a code save the data into database

// we can not use autowired for dependency it can create generated constructor Dependency