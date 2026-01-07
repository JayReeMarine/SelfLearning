check quickly splashkit

1. Terminal

2. types

3. utilites

4. input

g++ main.cpp -o main -I/usr/local/include -L/usr/local/lib -lsplashkit && ./main


좋은 판단이야.
**“파이썬 베이스 → C++ + SplashKit 튜터 시연”** 이면, 지금 상황에서 제일 위험한 건

> ❌ C++ 문법을 전부 배우려는 것
> 이고, 제일 좋은 전략은
> ✅ **FIT1045에서 실제로 쓰는 범위만 정확히 체득하는 것**이야.

그래서 아래 계획은 **“4.5일 집중 준비 → 5분 영상 + 메일 제출”**을 목표로 한,
**현실적으로 성공 확률이 가장 높은 계획표**야.

---

# 전체 전략 한 줄 요약

> **C++를 배우는 게 아니라
> “FIT1045에서 가르치는 C++ + SplashKit 스타일”을 그대로 익힌다**

---

# 📅 4.5일 현실적 준비 계획표

## Day 0 (오늘 저녁, 1~2시간) — 방향 고정 & 환경 안정화

**목표:** 더 이상 환경 때문에 시간 안 쓰게 만들기

### 해야 할 것

* [ ] C++ + SplashKit 컴파일/실행 **1번 더 성공 확인**
* [ ] `write_line`, `read_line`, `struct`, `function`, `procedure`가 되는지 확인
* [ ] VS Code에서 **터미널 → 컴파일 → 실행 루틴** 익숙해지기

### 딱 이 코드까지만

```cpp
struct Person
{
    string name;
    int age;
};

void print_person(Person p)
{
    write_line(p.name);
    write_line(p.age);
}

int main()
{
    Person p;
    p.name = "Alex";
    p.age = 20;

    print_person(p);
}
```

👉 이게 돌아가면 **환경은 끝**이야. 더 손대지 마.

---

## Day 1 (집중 4~5시간) — C++ “FIT1045 범위” 핵심 정리

**목표:** 파이썬과의 차이를 “설명할 수 있을 정도”로 이해

### 1️⃣ 문법 차이 (Python → C++)

집중할 것만:

| 개념        | Python     | C++            |
| --------- | ---------- | -------------- |
| 출력        | `print()`  | `write_line()` |
| 입력        | `input()`  | `read_line()`  |
| 함수        | 자유         | 반환 타입 필요       |
| procedure | 없음         | `void`         |
| struct    | dict/class | `struct`       |
| 변수 선언     | 필요 없음      | 타입 필수          |

### 2️⃣ 반드시 체득해야 할 C++ 포인트

* [ ] 타입 선언 (`int`, `double`, `string`)
* [ ] `struct`
* [ ] `void` 함수 vs 값 반환 함수
* [ ] pass by value vs `&` reference (개념만)
* [ ] `.field` 접근

### 실습

* `Student` struct
* 평균 점수 계산 함수
* 출력 procedure

---

## Day 2 (4~5시간) — SplashKit “튜터가 쓰는 API만”

**목표:** SplashKit을 **라이브러리가 아닌 ‘교재 도구’로 이해**

### 반드시 익힐 것

#### 콘솔 I/O

* `write_line`
* `read_line`
* `read_integer`
* `read_double`

#### 기본 타입

* `Point2D`
* `Circle`
* `Color`
  (그림 그리기 개념 이해만)

#### 스타일 포인트

* main은 짧게
* 의미 있는 함수 이름
* 절차적 흐름 강조

### 절대 하지 말 것

❌ 복잡한 그래픽
❌ animation / bitmap 깊게
❌ 포인터 남발

---

## Day 3 (4~5시간) — “영상용 코드” 완성

**목표:** 제출할 코드 100% 확정

### 코드 요구사항 다시 체크

* [x] `struct`
* [x] `main`
* [x] function (return)
* [x] procedure (`void`)
* [x] `write_line`
* [x] 100줄 이하
* [x] 컴파일 & 실행 OK

### 이 날 할 일

* [ ] 코드 리팩토링 (주석 제거해도 이해 가능?)
* [ ] 변수/함수 이름 FIT1045 스타일로
* [ ] 출력 결과 예측 가능하게

### 완성 기준

> **“학생에게 이 코드로 20분 설명 가능하다”**

---

## Day 4 (3~4시간) — 말하기 & 영상 리허설

**목표:** “튜터 같은 말투” 만들기

### 말해야 할 핵심 포인트 (외워도 됨)

1. 왜 struct를 썼는가
2. function vs procedure 차이
3. pass by value 설명
4. main은 흐름만 보여준다
5. SplashKit이 I/O를 담당한다

### 리허설 방법

* 코드 보면서 혼자 말하기
* 5분 타이머 켜고 설명
* 막히는 부분 메모

---

## Day 4.5 (1~2시간) — 촬영 & 제출 준비

**목표:** 결과물 완성

### 촬영 팁

* Zoom 혼자 회의
* 편집 ❌
* 실수해도 침착하게 설명
* 컴파일 → 실행은 꼭 보여주기

### 동시에 준비

* Language familiarity 문단 작성
* 수업 가능 시간 정리
* 메일 답장 초안 작성

---

# 🎯 이 계획의 핵심 강점

* ❌ “C++ 전문가”를 목표로 안 함
* ✅ “FIT1045 튜터 적합도”를 목표로 함
* ❌ 범위 넓히지 않음
* ✅ 요구사항에만 정확히 맞춤

---

## 다음 단계 제안 (지금 선택 가능)

원하면 **바로 다음 중 하나로 이어서 갈 수 있어**:

1️⃣ **Day 1용 “Python → C++ 대응 튜토리얼 코드” 바로 시작**
2️⃣ **영상 제출용 ‘정답 예제 코드’ 먼저 완성**
3️⃣ **말하기 스크립트(5분 분량) 미리 작성**

지금 상황에선
👉 **1️⃣ → 2️⃣ → 3️⃣ 순서**가 가장 좋아.

어느 걸로 바로 시작할지 말해줘.
