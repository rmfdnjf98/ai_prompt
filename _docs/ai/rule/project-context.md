# 프로젝트 컨텍스트: 블로그 만들기

## 1. 프로젝트 개요

이 프로젝트는 Spring Boot를 사용하여 간단한 블로그 기능을 구현하는 것을 목표로 합니다.
사용자는 회원가입 및 로그인을 할 수 있으며, 게시글과 댓글을 작성하고 조회할 수 있습니다.

## 2. 전체 아키텍처

- **MVC (Model-View-Controller) 패턴**: 웹 계층은 Spring MVC를 사용하여 구현되었습니다.
- **3-Tier Architecture**:
    - **Presentation Layer (`Controller`)**: 사용자의 요청을 받아 응답을 처리합니다. SSR(서버 사이드 렌더링)을 위해 Mustache 템플릿을 반환합니다.
    - **Business Layer (`Service`)**: 비즈니스 로직을 처리하며, 트랜잭션을 관리합니다. Entity를 직접 노출하지 않고 DTO로 변환하여 Controller에 전달합니다.
    - **Data Access Layer (`Repository`)**: Spring Data JPA를 사용하여 데이터베이스와 상호작용합니다.
- **도메인 기반 패키지 구조**: `user`, `board`, `reply` 와 같이 각 도메인별로 관련된 모든 클래스(Controller, Service, Repository, Entity, DTO 등)를 하나의 패키지에 모아 관리합니다.
- **공통 응답 래퍼**: REST API의 경우, `_core/utils/Resp.java`를 사용하여 일관된 형식의 JSON 응답을 제공합니다.

## 3. 기술 스택

| 구분      | 기술                               | 버전/사양       | 목적                       |
| --------- | ---------------------------------- | --------------- | -------------------------- |
| **Backend** | Java                               | 21              | 주력 개발 언어             |
|           | Spring Boot                        | 3.4.0           | 애플리케이션 프레임워크    |
|           | Spring Data JPA                    | -               | 데이터베이스 ORM           |
| **Frontend**| Mustache                           | -               | 서버 사이드 렌더링 템플릿 엔진 |
| **Database**| H2 Database                        | -               | 인메모리 관계형 데이터베이스 |
| **Library** | Lombok                             | -               | 보일러플레이트 코드 제거   |
| **Build**   | Gradle                             | -               | 의존성 관리 및 빌드 도구   |

## 4. 핵심 도메인 및 데이터 모델

- **User**: 사용자 정보를 관리하는 Entity. (id, username, password, email)
- **Board**: 게시글 정보를 관리하는 Entity. (id, title, content)
  - `User`와 N:1 연관관계를 가집니다 (한 명의 유저는 여러 게시글 작성 가능).
- **Reply**: 댓글 정보를 관리하는 Entity.
  - `User`, `Board`와 연관관계를 가질 것으로 예상됩니다.

## 5. 주요 설정 및 규칙

- **OSIV (Open Session In View)**: `false`로 비활성화하여 Service 레이어 밖에서의 지연 로딩을 방지합니다.
- **Fetch Strategy**: 모든 JPA 연관관계는 `FetchType.LAZY` (지연 로딩)를 원칙으로 합니다.
- **인증**: Spring Security 대신 `HttpSession`을 이용한 세션 기반 인증을 사용합니다.
- **데이터 초기화**: `resources/db/data.sql` 파일을 통해 애플리케이션 시작 시 초기 데이터를 로드합니다.
- **H2 Console**: 개발 편의를 위해 H2 데이터베이스 콘솔(`localhost:8080/h2-console`)이 활성화되어 있습니다.
