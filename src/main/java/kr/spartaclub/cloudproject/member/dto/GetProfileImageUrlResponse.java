package kr.spartaclub.cloudproject.member.dto;

import lombok.Getter;

@Getter
public class GetProfileImageUrlResponse {

    private final String url;

    public GetProfileImageUrlResponse(String url) {
        this.url = url;
    }
}
