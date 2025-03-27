package com.blog.blogapplication.services;

import java.util.List;

import com.blog.blogapplication.entities.BlogDetail;

public interface BlogService {

    List<BlogDetail> getAllBlogs(String email);
    BlogDetail getBlogById(String id);
    BlogDetail saveBlog(BlogDetail blogDetail);
    BlogDetail updateBlog(BlogDetail blogDetail);
    void deleteBlog(String id);
}
