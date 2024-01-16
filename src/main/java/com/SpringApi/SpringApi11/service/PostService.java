package com.SpringApi.SpringApi11.service;

import com.SpringApi.SpringApi11.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto); // return back PostDto

    PostDto getPostById(long id);


    List<PostDto> getAllPost();
}
