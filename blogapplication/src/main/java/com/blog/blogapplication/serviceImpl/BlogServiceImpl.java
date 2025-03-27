package com.blog.blogapplication.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogapplication.entities.BlogDetail;
import com.blog.blogapplication.repositories.BlogRepo;
import com.blog.blogapplication.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public List<BlogDetail> getAllBlogs(String email) {
        return blogRepo.findByUserEmail(email);
    }


    @Override
    public BlogDetail getBlogById(String id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public BlogDetail saveBlog(BlogDetail blogDetail) {
        return blogRepo.save(blogDetail);
    }

    @Override
    public BlogDetail updateBlog(BlogDetail blogDetail) {
        return blogRepo.save(blogDetail);
    }

    @Override
    public void deleteBlog(String id) {
        blogRepo.deleteById(id);
    }

}
