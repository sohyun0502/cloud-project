package kr.spartaclub.cloudproject.member.dto;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
    private String name;
    private Integer age;
    private String mbti;
}
