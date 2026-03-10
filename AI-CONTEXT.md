# Demo Project Root

## 목적

Spring Boot 기반의 주소 연동 및 게시판(Board), 댓글(Reply), 사용자(User) 기능을 포함한 샘플링 데모 프로젝트.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| build.gradle | 프로젝트 의존성 및 빌드 설정 |
| AI-GUIDE.md | AI 에이전트 가이드 및 스킬 정의 |
| GEMINI.md | Gemini CLI 전용 프로젝트 컨텍스트 및 규칙 |
| AGENTS.md | 프로젝트 내 사용 가능한 에이전트 목록 |
| CLAUDE.md | Claude 전용 가이드 (필요 시) |
| settings.gradle | 프로젝트 설정 및 모듈 정의 |
| gradlew / gradlew.bat | Gradle 래퍼 실행 스크립트 |

## 하위 디렉토리

- `.ai/` - AI 관련 규칙 및 스킬 정의
- `.person/` - 개인별 작업 규칙, 태스크 및 워크플로우
- `src/` - 소스 코드 및 리소스 (Java, Resources)
- `gradle/` - Gradle 래퍼 설정 파일

## AI 작업 지침

- `AI-GUIDE.md`의 규칙을 최우선으로 준수한다.
- `GEMINI.md`의 컨텍스트를 로드하여 세션 초기 설정을 수행한다.
- `.ai/skills` 폴더의 스킬을 적극적으로 활용한다.

## 테스트

- `./gradlew test` 명령을 통해 전체 테스트를 실행한다.

## 의존성

- 내부: Spring Boot, Lombok, Mustache
- 외부: H2 Database (InMemory), Spring Data JPA
