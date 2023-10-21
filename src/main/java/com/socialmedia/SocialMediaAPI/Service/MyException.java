package com.socialmedia.SocialMediaAPI.Service;

public class MyException extends Exception {
    // Tạo một lớp ngoại lệ tùy chỉnh kế thừa từ lớp Exception (hoặc một lớp con của Exception)
    public MyException(String message) {
        super(message);
    }
}
