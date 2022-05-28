package com.byeounggwan.blog.service;

import com.byeounggwan.blog.repository.UsersRepository;
import com.byeounggwan.blog.dto.SignupRequestDto;
import com.byeounggwan.blog.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUsers(SignupRequestDto requestDto) {
        // 회원 ID 중복 확인
        String nickname = requestDto.getNickname();
        Optional<Users> found = usersRepository.findByNickname(nickname);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());



        Users users = new Users(nickname, password);
        usersRepository.save(users);
    }
}