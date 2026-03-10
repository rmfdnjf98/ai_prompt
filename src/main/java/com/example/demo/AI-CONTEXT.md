<!-- Parent: ../../../../../AI-CONTEXT.md -->

# com.example.demo

## 목적

애플리케이션의 메인 패키지로, Spring Boot 엔트리 포인트와 도메인별 패키지(Board, User, Reply, Juso)를 포함한다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| DemoApplication.java | Spring Boot 애플리케이션 실행 클래스 |

## 하위 디렉토리

- `board/` - 게시판 관련 도메인 (Entity, Controller, Service, Repository)
- `user/` - 사용자 관리 도메인
- `reply/` - 댓글 관련 도메인
- `juso/` - 주소 연동 API 관련 컨트롤러
- `_core/` - 공통 유틸리티 및 예외 처리

## AI 작업 지침

- 새로운 도메인 추가 시 이 디렉토리 하위에 패키지를 생성한다.
- 각 패키지는 Controller, Service, Repository, Request/Response DTO, Entity 구조를 따른다.

## 테스트

- 각 도메인 패키지 하위의 로직은 `src/test/java`에서 대응하는 테스트 클래스로 검증한다.
