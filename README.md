# SOLO PROJECT TO-DO LIST 만들기
---

🌻 TO-DO APP 은 할 일 목록을 관리하는 웹 애플리케이션으로, 기본적인 CRUD 기능만 있는 CHECKLIST 입니다.

1. API Docs와 테이블 구성을 참고하여 TO-DO APP 개발
2. TOMCAT 설치, 로컬 환경 수동 배포
3. Ngrok 을 통해 외부에서 접근 가능한 로컬 환경 구축
4. Postman과 todobackend.com 결과 확인

### CRUD
- Create : 할 일 목록 등록
- Read : 전체 할 일 목록 조회, 등록된 할 일의 특정 ID를 입력해 조회 가능
- Update : 한 일에 완료 표시, 할 일의 내용 수정
- Delete : 전체 할 일 목록 삭제, 등록된 할 일의 특정 ID를 입력해 삭제 가능

### TIL
- DTO 클래스 생성 시, 컨트롤러에서 회원 정보로 전달받는 각 데이터 항목을 DTO 클래스의 멤버 변수로 추가하면 됨
- RequestBody가 필요한 핸들러 메서드 : POST, PATCH, PUT 같이 리소스 추가/변경이 발생할 때
- \<S extends T> S save (S entity); -> save는 제네릭으로 받은 타입(T)으로 값 반환
- DTO 클래스 : API 계층에서 클라이언트의 Request Body를 전달받고 클라이언트에게 되돌려 줄 응답 데이터를 담는 역할
- Entity 클래스 : API 계층에서 전달받은 요청 데이터를 기반으로 서비스 계층에서 데이터 액세스 계층과 연동하면서 비즈니스 로직을 처리하기 위해 필요한 데이터를 전달받고, 비즈니스 로직 처리 후 결과값을 다시 API 계층으로 리턴
- @AllArgsConstructor 클래스에 추가된 모든 멤버 변수를 파라미터로 갖는 생성자를 자동 생성
- @NoArgsConstructor 파라미터가 없는 기본 생성자를 자동 생성
- @RequestParam 은 단일 파라미터 값을 넘겨받을 때, @PathVariable 은 URL에서 각 구분자에 들어오는 값을 처리할 때
- Spring은 메서드 매개변수에 적절한 어노테이션을 사용해 요청의 바디(body)와 경로 변수(path variable)를 매핑하므로 @PathVariable - @Requestbody 순으로 어노테이션을 작성해야 함

### TODO
- JPA 컬럼 생성이 알파벳 순서로 되는 것 -> 혹시 지정할 방법이 있나?