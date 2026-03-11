package kr.spartaclub.cloudproject.global.error;

import lombok.Getter;


public class FileUploadFailException extends RuntimeException {

    public FileUploadFailException(String message) {
        super(message);
    }
}
