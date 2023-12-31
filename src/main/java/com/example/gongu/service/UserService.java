package com.example.gongu.service;

import com.example.gongu.domain.dto.UserDto;
import com.example.gongu.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserMapper userMapper;

    //아이디 중복검사
    public int idCheck(String userId){
        return userMapper.idCheck(userId);
    }

    // 닉네임 중복검사
    public int nickNameCheck(String userNickname){
        return userMapper.nickNameCheck(userNickname);
    }

    // 이메일 중복검사
    public int emailCheck(String userEmail){
        return userMapper.emailCheck(userEmail);
    }

    // 번호 중복검사
    public int phoneCheck(String userPhone){
        return userMapper.phoneCheck(userPhone);
    }


    //등록
    public void register(UserDto userDto) {
        if (userDto == null) {
            throw new IllegalArgumentException("회원정보가 누락되었습니다");
        }
        userMapper.insert(userDto);
        //log.info("가입완료오오오오오오오******************");

    }

    //아이디 비밀번호를 입력받아서 로그인
    public UserDto find(String userId, String userPassword){
//        return Optional.ofNullable(userMapper.select(userId, userPassword))
//                .orElseThrow(()->{throw new IllegalArgumentException("조회결과 없음");
//                });
        return userMapper.select(userId,userPassword);
    }


    //회원 삭제
    public void remove(Long userNumber) {
        userMapper.deleteUser(userNumber);
    }

    //번호로 아이디 찾기
    public String verifyPhoneNumber(String userPhone){
        String userId = userMapper.verifyPhoneNumber(userPhone);
        //userId를 select
        if(userId != null && !userId.isEmpty()){
            log.info("******일치하는 번호가 있음*******");
            return userId;
        }else {
            log.info("***----일치하는 번호 없음----***");
            return null;
        }
    }

    //아이디와 번호로 비밀번호 찾기
    public String verifyPhoneNumberPw(String userId, String userPhone){
       // log.info("verify PhoneNumberPw method Phone Number : "+userPhone);
       // log.info("verify PhoneNumberPw method Phone Number : "+userId);

        String userPassword = userMapper.verifyPhoneNumberPw(userId, userPhone);

        //log.info("verify PhoneNumberPw userPassword"+userPassword);

        if(userPassword != null){
            log.info("=====일치하는 번호와 아이디가 있음=====");
            return userPassword;
        }else{
            log.info("===---일치하는 번호와 아이디가 없음---===");
            return null;
        }
    }

    // 회원정보 수정
    public void modifyUser(String userNickname, String userPhone, String userEmail, Long userNumber){
        userMapper.updateUser(userNickname, userPhone, userEmail, userNumber);}


    // 내정보 페이지
    public UserDto findMyPage(Long userNumber){
        return userMapper.selectMyPage(userNumber);
    }
    // 전화번호 중복
    public Long findPhone(String userPhone){return userMapper.selectPhone(userPhone);}
    // 이메일 중복
    public Long findEmail(String userEmail){return userMapper.selectEmail(userEmail);}



}

