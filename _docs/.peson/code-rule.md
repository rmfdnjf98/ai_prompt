# 프로젝트 코드 컨벤션

이 문서는 이 프로젝트의 코딩 컨벤션과 표준을 간략하게 설명합니다.

## 일반 규칙

1.  **DTO는 서비스(Service) 계층에서 생성합니다.** 엔티티(Entity)는 컨트롤러(Controller)로 전달해서는 안 됩니다. 컨트롤러는 DTO만 받고 반환해야 합니다.
2.  **모든 엔티티 연관관계는 지연 로딩(LAZY loading)을 사용해야 합니다.** `OSIV`(Open Session In View) 설정은 `false`여야 합니다.
3.  **요청 DTO의 이름은 기능에 따라 지정해야 합니다.** 예를 들어, `SaveDTO`, `UpdateDTO`, `LoginDTO` 등입니다.

## 구조 및 명명 규칙

-   **패키지 구성**: 코드는 기능별로 구성됩니다 (예: `com.example.demo.board`, `com.example.demo.user`).
-   **클래스 명명**:
    -   엔티티: `User.java`
    -   컨트롤러: `UserController.java`
    -   서비스: `UserService.java`
    -   리포지토리: `UserRepository.java`
    -   요청 DTO: `UserRequest.java`
    -   응답 DTO: `UserResponse.java`
-   **메서드 명명**: 메서드 이름은 camelCase를 사용해야 합니다 (예: `findByUsername`).
-   **테이블 명명**: 데이터베이스 테이블 이름은 `_tb` 접미사를 붙여야 합니다 (예: `user_tb`, `board_tb`).

## Lombok

이 프로젝트는 상용구 코드를 줄이기 위해 Lombok을 적극적으로 사용합니다.

-   `@Data`: DTO에 사용합니다.
-   `@NoArgsConstructor`: 엔티티와 DTO에 사용합니다.
-   `@RequiredArgsConstructor`: 컨트롤러와 서비스에서 생성자 의존성 주입에 사용합니다.
-   `@Builder`: 테스트 데이터 생성을 위해 엔티티 클래스에 사용합니다.

## 컨트롤러 계층 (`@Controller`)

-   뷰를 반환하는 컨트롤러에는 `@Controller`를 사용합니다.
-   의존성은 `final` 필드와 `@RequiredArgsConstructor`를 사용한 생성자 주입으로 주입됩니다.
-   메서드 매개변수는 DTO여야 합니다.

```java
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final HttpSession session;

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
```

## 서비스 계층 (`@Service`)

-   `@Service`로 어노테이션을 답니다.
-   읽기 전용 트랜잭션을 위해 클래스 수준에서 `@Transactional(readOnly = true)`를 추가합니다. 데이터베이스에 쓰는 메서드에는 `@Transactional`을 사용합니다.
-   생성자 주입을 사용하여 리포지토리 및 기타 서비스를 주입합니다.

```java
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

}
```

## 리포지토리 계층 (`@Repository`)

-   `JpaRepository<Entity, IdType>`를 확장합니다.
-   Spring Data JPA에 의해 자동으로 등록되므로 `@Repository`를 추가할 필요가 없습니다.

```java
public interface BoardRepository extends JpaRepository<Board, Integer> {
}
```

## 엔티티 계층 (`@Entity`)

-   `@Entity`로 어노테이션을 답니다.
-   `@Table(name = "board_tb")`을 사용하여 테이블 이름을 명시적으로 지정합니다.
-   기본 키는 `Integer` 타입의 `id`여야 하며 `@GeneratedValue(strategy = GenerationType.IDENTITY)`를 사용합니다.
-   모든 다대일 관계에는 `@ManyToOne(fetch = FetchType.LAZY)`를 사용합니다.

```java
@NoArgsConstructor
@Data
@Entity
@Table(name = "board_tb")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
```

## DTO (Data Transfer Objects)

-   요청 및 응답 DTO는 래퍼 클래스(예: `BoardRequest`, `BoardResponse`) 내에 `static` 내부 클래스로 정의됩니다.
-   요청 DTO는 기능에 따라 이름을 지정해야 합니다(예: `SaveOrUpdateDTO`).

```java
public class BoardRequest {

    // 규칙: 요청 DTO는 기능명으로 이름을 짓는다.
    @Data
    public static class SaveOrUpdateDTO {
        private String title;
        private String content;
    }
}
```
