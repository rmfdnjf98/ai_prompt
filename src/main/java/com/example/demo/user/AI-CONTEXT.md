<!-- Parent: ../AI-CONTEXT.md -->

# User Domain

## 목적

사용자 가입, 로그인, 정보 관리 등을 담당하는 도메인.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| User.java | 사용자 Entity |
| UserController.java | 회원가입/로그인 페이지 및 API 처리 |
| UserService.java | 회원 관리 로직 |
| UserRepository.java | 사용자 DB 접근 로직 |
| UserRequest.java | 사용자 요청 DTO |
| UserResponse.java | 사용자 응답 DTO |

## AI 작업 지침

- 사용자 비밀번호는 보안 수칙에 따라 처리한다.
- 회원가입 시 주소 연동 API를 활용하는 경우 `juso` 도메인과 협업한다.
