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
- RequestBody가 필요한 핸들러 메서드 : POST, PATCH, PUT 같회 리소스 추가/변경이 발생할 때