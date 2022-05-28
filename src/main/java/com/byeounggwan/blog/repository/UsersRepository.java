package com.byeounggwan.blog.repository;

import com.byeounggwan.blog.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByNickname(String nickname);
}