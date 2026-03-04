# Gemini Skill: Spring Boot 프로젝트 코딩 스타일

**버전:** 1.0
**설명:** 이 스킬은 Spring Boot 데모 프로젝트를 위한 특정 코딩 컨벤션을 정의합니다. 이 프로젝트 내에서 코드를 읽거나 작성할 때 이 스킬을 적용하십시오.

---

## Skill Details

- **Skill Name:** `ProjectCodingStyle`

---

## Context

- **Project Type:** `Java Spring Boot`
- **Primary Language:** `Java`
- **Database:** `H2 (application.properties 기반 인메모리)`
- **Persistence Framework:** `Spring Data JPA`
- **View Template:** `Mustache`

---

## Rules

### 1. **DTO 생성 위치 (ID: `GENERAL-01`)**
- **Rule:** DTO는 서비스(Service) 계층에서 생성해야 합니다.
- **Description:** JPA 엔티티를 컨트롤러로 전달하지 마십시오. 컨트롤러는 들어오는 요청과 나가는 응답에 대해 DTO와만 상호 작용해야 합니다.
- **Applies to:** `Controller`, `Service`

### 2. **지연 로딩 사용 (ID: `GENERAL-02`)**
- **Rule:** 모든 엔티티 연관관계는 지연 로딩(LAZY)을 사용해야 합니다.
- **Description:** 모든 JPA 연관관계 어노테이션(예: `@ManyToOne`, `@OneToMany`)의 `fetch` 속성을 `FetchType.LAZY`로 설정하십시오. OSIV(Open Session In View) 패턴은 비활성화되어 있습니다.
- **Applies to:** `Entity`
- **Example:**
  ```java
  // 올바른 사용법
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  // 잘못된 사용법
  @ManyToOne
  private User user;
  ```

### 3. **DTO 명명 규칙 (ID: `NAMING-01`)**
- **Rule:** 요청 DTO의 이름은 기능/역할에 따라 지정합니다.
- **Description:** 정적 내부 클래스로 정의된 요청 DTO의 이름은 `SaveDTO`, `LoginDTO`, `UpdateDTO`와 같이 지정해야 합니다.
- **Applies to:** `DTO`, `Request`
- **Example:**
  ```java
  public class BoardRequest {
      @Data
      public static class SaveDTO { // 기능 기반 이름
          private String title;
          private String content;
      }
  }
  ```

### 4. **테이블 명명 규칙 (ID: `NAMING-02`)**
- **Rule:** 데이터베이스 테이블은 `_tb` 접미사를 가져야 합니다.
- **Description:** 엔티티에 `@Table` 어노테이션을 사용할 때, `name` 속성은 `_tb`로 끝나야 합니다.
- **Applies to:** `Entity`
- **Example:**
  ```java
  // 올바른 사용법
  @Entity
  @Table(name = "user_tb")
  public class User { ... }

  // 잘못된 사용법
  @Entity
  @Table(name = "user")
  public class User { ... }
  ```

### 5. **패키지 구조 (ID: `NAMING-03`)**
- **Rule:** 패키지는 기능별로 구성됩니다.
- **Description:** 단일 기능(예: `board`, `user`)과 관련된 클래스들을 자체 패키지로 그룹화합니다.
- **Applies to:** `Project Structure`

### 6. **의존성 주입 (ID: `ARCHITECTURE-01`)**
- **Rule:** `@RequiredArgsConstructor`를 이용한 생성자 주입을 사용합니다.
- **Description:** 컨트롤러와 서비스에서는 의존성을 `private final`로 선언하고 클래스에 `@RequiredArgsConstructor` 어노테이션을 사용합니다.
- **Applies to:** `Controller`, `Service`

### 7. **서비스 트랜잭션 (ID: `ARCHITECTURE-02`)**
- **Rule:** 서비스는 기본적으로 트랜잭션이며 읽기 전용입니다.
- **Description:** 서비스 클래스는 `@Transactional(readOnly = true)`로 어노테이션되어야 합니다. 쓰기 작업을 수행하는 메서드는 개별적으로 `@Transactional`로 어노테이션되어야 합니다.
- **Applies to:** `Service`

### 8. **DTO 구조 (ID: `ARCHITECTURE-03`)**
- **Rule:** DTO는 정적 내부 클래스입니다.
- **Description:** 요청 및 응답 DTO는 해당 `...Request.java` 또는 `...Response.java` 파일 내에서 `public static` 내부 클래스로 정의되어야 합니다.
- **Applies to:** `DTO`

### 9. **Lombok 사용법 (ID: `LOMBOK-01`)**
- **Rule:** Lombok 어노테이션을 사용하여 상용구 코드를 줄입니다.
- **Description:** DTO에는 `@Data`, 엔티티/DTO에는 `@NoArgsConstructor`, 의존성 주입에는 `@RequiredArgsConstructor`, 테스트 데이터 생성에는 `@Builder`를 사용합니다.
- **Applies to:** `Entity`, `DTO`, `Controller`, `Service`

### 10. **기본 키(Primary Key) 정의 (ID: `ENTITY-01`)**
- **Rule:** 기본 키는 `Integer`이며 `IDENTITY` 전략으로 생성됩니다.
- **Description:** 기본 키 필드는 `private Integer id;`여야 하며 `@Id`와 `@GeneratedValue(strategy = GenerationType.IDENTITY)`로 어노테이션되어야 합니다.
- **Applies to:** `Entity`
