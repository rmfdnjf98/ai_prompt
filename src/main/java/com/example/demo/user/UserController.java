package com.example.demo.user;

import org.springframework.stereotype.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/join-form")
    public String joinForm() {
        return "user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.Join reqDTO) {
        // 필수 값 검증 (상세 주소 포함)
        if (reqDTO.getZipcode() == null || reqDTO.getZipcode().isBlank() ||
            reqDTO.getRoadAddress() == null || reqDTO.getRoadAddress().isBlank() ||
            reqDTO.getDetailAddress() == null || reqDTO.getDetailAddress().isBlank()) {
            throw new RuntimeException("모든 주소 정보를 입력해주세요."); // 공통 예외 처리가 있다면 그쪽으로
        }
        userService.join(reqDTO);
        return "redirect:/"; // 가입 완료 후 홈으로
    }
}
