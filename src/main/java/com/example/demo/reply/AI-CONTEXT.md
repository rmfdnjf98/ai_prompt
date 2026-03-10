<!-- Parent: ../AI-CONTEXT.md -->

# Reply Domain

## 목적

게시글에 달리는 댓글 기능을 담당하는 도메인.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| Reply.java | 댓글 Entity (Board와 다대일 관계) |
| ReplyController.java | 댓글 CRUD API 처리 |
| ReplyService.java | 댓글 비즈니스 로직 |
| ReplyRepository.java | 댓글 DB 접근 로직 |
| ReplyRequest.java | 댓글 요청 DTO |
| ReplyResponse.java | 댓글 응답 DTO |

## AI 작업 지침

- 댓글은 반드시 특정 게시글(`Board`)에 종속된다.
- 삭제 기능 시 작성자 확인 로직을 서비스 레이어에 구현한다.
