package com.example.demo.user;

import lombok.Data;

/**
 * RULE :Max(User의 모든 값), Min(User의 최소 정보), Detail(User의 상세 정보) DTO이름을 최소, 최대,
 * 상세를 기본으로 한다.
 */
public class UserResponse {

    @Data
    public static class Min {
        private String username;
        private String email;

        public Min(User user) {
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }
}
