package com.byeounggwan.blog.service;


import com.byeounggwan.blog.model.Contents;
import com.byeounggwan.blog.repository.ContentsRepository;
import com.byeounggwan.blog.dto.ContentsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ContentsService {
    @Autowired
    private final ContentsRepository ContentsRepository;


    @Transactional
    public Long update(Long id, ContentsRequestDto requestDto) {
        Contents Contents = ContentsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        Contents.update(requestDto);
        return Contents.getId();
    }
}