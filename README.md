# 즐겨찾기 - API 테스트/문서자동화

## 1단계 - 회원 관리 기능

### 회원정보 수정 기능

#### 요구 사항
    - [x] 회원 정보를 관리하는 기능 구현
        - [x] 서버 구현
            - 가입 시 발생하는 side case에 대한 예외처리
        - [x] 뷰 구현
    - [x] 자신의 정보만 수정 가능하도록 해야하며 로그인이 선행되어야 함
        - [x] 테스트 작성
    - [x] 토큰의 유효성 검사와 본인 여부를 판단하는 로직 추가
    - [x] side case에 대한 예외처리
        - [x] 예외 사항 작성
            - 로그인 선행이 필요한 uri에 로그인 없이 요청
            - 요청 값에 대한 예외처리
            - 클라이언트단에서 
                - password 와 password 확인 일치 검사
                - 이메일 정규표현식 일치 검사
        - [x] 테스트 작성
    - [ ] 인수 테스트와 단위 테스트 작성
    - [ ] API 문서를 작성하고 문서화를 위한 테스트 작성
    - [x] 페이지 연동

#### 추가 사항
    - [x] 로그인 테스트 추가
        - [x] 요청 값이 빈 값, 혹은 null일 경우
        - [x] 계정이 없을 경우
        - [X] 비밀번호가 틀렸을 경우
        
## 2단계 - 즐겨찾기 기능

### 즐겨찾기 기능

#### 요구사항

- [x] 즐겨찾기 기능을 추가(추가,삭제,조회)
- [x] 자신의 정보만 수정 가능하도록 해야하며 로그인이 선행되어야 함
- [x] 토큰의 유효성 검사와 본인 여부를 판단하는 로직 추가(interceptor, argument resolver)
- [x] side case에 대한 예외처리 필수
- [x] 인수 테스트와 단위 테스트 작성
- [x] API 문서를 작성하고 문서화를 위한 테스트 작성
- [X] 페이지 연동