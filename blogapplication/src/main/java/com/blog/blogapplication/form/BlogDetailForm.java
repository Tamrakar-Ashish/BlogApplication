package com.blog.blogapplication.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

// This class is a form class that is used to create a form for the blog details.

public class BlogDetailForm {

    private String userEmail;
    private String title;
    private String content;
    private String author;
    
}
