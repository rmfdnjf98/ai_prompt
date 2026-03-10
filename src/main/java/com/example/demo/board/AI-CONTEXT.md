<!-- Parent: ../AI-CONTEXT.md -->

# Board Domain

## 목적

게시글 작성, 조회, 수정, 삭제 기능을 담당하는 도메인.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| Board.java | 게시판 Entity |
| BoardController.java | HTTP 요청 처리 및 뷰 반환 |
| BoardService.java | 비즈니스 로직 처리 |
| BoardRepository.java | 데이터베이스 접근 로직 (JPA) |
| BoardRequest.java | 클라이언트 요청 DTO |
| BoardResponse.java | 서버 응답 DTO |

## AI 작업 지침

- 모든 비즈니스 로직은 `BoardService`에 집중한다.
- 컨트롤러는 단순 요청 전달 및 응답 처리만 수행한다.
- 데이터 반환 시 반드시 Response DTO를 활용한다.
