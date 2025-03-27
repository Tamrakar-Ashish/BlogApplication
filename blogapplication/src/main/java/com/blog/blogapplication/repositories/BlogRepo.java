package com.blog.blogapplication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.blogapplication.entities.BlogDetail;

@Repository
public interface BlogRepo extends JpaRepository<BlogDetail, String> {

    Optional<BlogDetail> findById(String id);
    List<BlogDetail> findByUserEmail(String email);
}
