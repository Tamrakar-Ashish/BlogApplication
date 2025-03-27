package com.blog.blogapplication.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.blogapplication.entities.BlogDetail;
import com.blog.blogapplication.form.BlogDetailForm;
import com.blog.blogapplication.services.BlogService;

@Controller
public class PageController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/homepage")
    public String home() {
        return "home"; // Maps to home.html in src/main/resources/templates
    }

    @RequestMapping("/createPost")
    public String createPost(Model model) {

        BlogDetailForm blogDetailForm=new BlogDetailForm();
        model.addAttribute("blogDetailForm",blogDetailForm);
        return "blogPost"; // Maps to createPost.html in src/main/resources/templates
    }

    @RequestMapping("/processBlog")
    public String processBlog(@Validated @ModelAttribute("blogDetailForm") BlogDetailForm blogDetailForm, BindResult bindResult) {
        //

        // Getting data from view page
        BlogDetail blogDetail =BlogDetail.builder()
        .title(blogDetailForm.getTitle())
        .author(blogDetailForm.getAuthor())
        .content(blogDetailForm.getContent())
        .userEmail(blogDetailForm.getUserEmail())
        .build();

        //Addind Id of post
        String Id=UUID.randomUUID().toString();
        blogDetail.setId(Id);
        String createdAt=java.time.LocalDateTime.now().toString();
        blogDetail.setCreatedAt(createdAt);
        System.out.println(blogDetail);

        //saving Blog into database
        blogService.saveBlog(blogDetail);
        return "blogpost"; // Maps to processBlog.html in src/main/resources/templates
    }

    @RequestMapping("/showBlog")
    public String showBlog() {

        return "showblog"; // Maps to showBlog.html in src/main/resources/templates
    }
}

