package com.example.gongu.mapper;

import com.example.gongu.domain.dto.LikeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    public void insert(LikeDto likeDto);

    public Long likeTotal(Long studyNumber);

    public List selectUser();

    public void delete(Long userNumber);
}

