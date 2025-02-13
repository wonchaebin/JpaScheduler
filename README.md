## ERD
![image](https://github.com/user-attachments/assets/20813ff1-fd53-4c7a-9202-b0c0124fdcdb)

## Schedule 포스트맨

### 1. POST 일정 등록
![image](https://github.com/user-attachments/assets/c7fa0f6a-2dd8-4a24-a1dd-247189104c88)

### 2. GET 단일 일정 조회
![image](https://github.com/user-attachments/assets/7a5ecbef-0e4e-4c9c-a30d-dc5391471805)

### 3. GET 전체 일정 조회
![image](https://github.com/user-attachments/assets/cdd916e0-d93e-456c-a289-e51b87532004)

### 4. PUT 일정 수정
![image](https://github.com/user-attachments/assets/ceee8250-7807-469a-9747-71142324d4a3)

### 5. DELETE 일정 삭제
![image](https://github.com/user-attachments/assets/f010318c-4e5a-4104-a104-5f6a90a3d09c)

## User 포스트맨

### 1. POST 유저 등록
![image](https://github.com/user-attachments/assets/9c56b67a-6cdf-4cc4-8ae6-a968224942a0)

### 2. GET 단일 유저 조회
![image](https://github.com/user-attachments/assets/6627507c-cf12-4b98-9ba9-9c40d79dc56c)

### 3. GET 전체 유저 조회
![image](https://github.com/user-attachments/assets/1ac38ebb-d4d2-461d-a28d-94acc3891b5c)

### 4. PUT 유저 수정
![image](https://github.com/user-attachments/assets/edfb5f2c-07d4-488f-9725-785ab17e88f6)

### 5. DELETE 유저 삭제
![image](https://github.com/user-attachments/assets/3af5a370-0c5d-433b-a5be-6fc269a70505)

## 기능 설명

### Lv 1. 일정 CRUD  `필수`

- 일정을 생성, 조회, 수정, 삭제할 수 있다.
- 일정은 `작성 유저명`, `할일 제목`, `할일 내용`, `작성일`, `수정일` 필드 가진다.
   `작성일`, `수정일` 필드는 `JPA Auditing`을 활용한다.

### Lv 2. 유저 CRUD  `필수`

- 유저를 생성, 조회, 수정, 삭제할 수 있다.
- 유저는 `유저명`, `이메일`, `작성일` , `수정일` 필드를 가진다.
- `작성일`, `수정일` 필드는 `JPA Auditing`을 활용한다.
- 연관관계를 구현하여 일정은 `작성 유저명` 필드 대신 `유저 고유 식별자` 필드를 가진다.

### Lv 3. 회원가입  `필수`

- 유저에 `비밀번호` 필드를 추가한다.

### Lv 4. 로그인(인증)  `필수`

- `이메일`과 `비밀번호`를 활용해 로그인 기능을 구현합니다.
- 회원가입, 로그인 요청은 인증 처리에서 제외합니다.
- 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 HTTP Status code 401을 반환한다.



